package com.team5.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.team5.service.Table_3_Service;
import com.team5.vo.Table_3_VO;

@WebServlet("/t3-info/*")
public class Table_3_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private Table_3_Service t3Service = new Table_3_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		int idx = cmd.lastIndexOf("/");
		cmd = cmd.substring(idx + 1);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(t3Service.selectBoardInfoList(null));
		} else if("view".equals(cmd)) {
			json = gson.toJson(t3Service.selectBoardInfo(Integer.parseInt(request.getParameter("biNum"))));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getRequestURI();
		int idx = cmd.lastIndexOf("/");
		cmd = cmd.substring(idx + 1);
		int result = 0;
		if("insert".equals(cmd)) {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = request.getReader();
			String str = null;
			while((str=br.readLine()) != null) {
				sb.append(str);
			}
			Table_3_VO json = gson.fromJson(sb.toString(), Table_3_VO.class);
			result = t3Service.insertBoardInfo(json);
		} else if("update".equals(cmd)) {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = request.getReader();
			String str = null;
			while((str=br.readLine()) != null) {
				sb.append(str);
			}
			Table_3_VO json = gson.fromJson(sb.toString(), Table_3_VO.class);
			result = t3Service.insertBoardInfo(json);
		} else if("delete".equals(cmd)) {
			result = t3Service.deleteBoardInfo(Integer.parseInt(request.getParameter("biNum")));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
