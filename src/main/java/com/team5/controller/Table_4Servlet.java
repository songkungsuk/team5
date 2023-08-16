package com.team5.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.team5.service.Table_4Service;
import com.team5.vo.Table_4_VO;


@WebServlet("/Table_4Servlet")
public class Table_4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();
    private Table_4Service tiService =  new Table_4Service();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Table_4_VO> TableList = tiService.getTable_4(null);
		String json = gson.toJson(TableList);
		doProcess(response, json);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

	
	public void doProcess(HttpServletResponse response, String json) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		
	}
}
