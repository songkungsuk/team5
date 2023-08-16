package com.team5.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.team5.common.CommandParser;
import com.team5.service.Table_2_Service;
import com.team5.vo.Table_2_VO;


@WebServlet("/table_2/*")
public class Table_2_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private Table_2_Service tService = new Table_2_Service();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		String cmd = CommandParser.getCmd(request);
		if("list".equals(cmd)) {
			json = gson.toJson(tService.getTables(null));
		}else if("one".equals(cmd)) {
			Table_2_VO table = tService.getTable(Integer.parseInt(request.getParameter("biNum")));
			json = gson.toJson(table);
		}
		doProcess(response, json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = null;
		while((str=br.readLine())!= null) {
			sb.append(str);
		}
		Table_2_VO table = gson.fromJson(sb.toString(), Table_2_VO.class);
		int result = 0;
		String cmd = CommandParser.getCmd(request);
		if("delete".equals(cmd)) {
			result = tService.deleteTable(table.getBiNum());
		}else if("insert".equals(cmd)) {
			result = tService.insertTable(table);
		}else if("update".equals(cmd)) {
			result = tService.updateTable(table);
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	public void doProcess(HttpServletResponse response, String json) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
