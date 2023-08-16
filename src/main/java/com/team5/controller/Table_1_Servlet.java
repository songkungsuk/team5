package com.team5.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.team5.service.Table_1_Service;
import com.team5.vo.Table_1_VO;


@WebServlet("/table_1/*")
public class Table_1_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();
    private Table_1_Service t1Service = new Table_1_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String json = "";
		if(cmd.equals("list")) {
			json = gson.toJson(t1Service.selectTable_1_List(null));
		}else if(cmd.equals("view") || cmd.equals("update")) {
			String biNum = request.getParameter("biNum");
			json = gson.toJson(t1Service.selectTable_1(Integer.parseInt(biNum)));
		}
		
		doProcess(response, json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = "";
		int result = 0;
		
		while((str=br.readLine()) != null) {
			sb.append(str);
		}
		System.out.println(sb.toString());
		Table_1_VO formatJ = gson.fromJson(sb.toString(), Table_1_VO.class);
		
		if(cmd.equals("insert")) {
			result = t1Service.insertTable_1(formatJ);
		}else if(cmd.equals("update")) {
			result = t1Service.updateTable_1(formatJ);
		}else if(cmd.equals("delete")) {			
			result = t1Service.deleteTable_1(formatJ.getBiNum());
		}
		
		doProcess(response, Integer.toString(result));
		
	}
	
	public void doProcess(HttpServletResponse response, String json) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
