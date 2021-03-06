package com.demoweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.service.AuthService;
import com.demoweb.vo.MemberVO;

@WebServlet(urlPatterns = { "/account/register.action" })
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		System.out.printf("[%s][%s][%s][%s]\n", memberId, passwd, confirm, email);
		
		//2. 요청 데이터 처리 ( 회원가입처리 )		
		MemberVO member = new MemberVO();
		member.setMemberId(memberId);
		member.setPasswd(passwd);
		member.setEmail(email);
		
		AuthService authService = new AuthService();
		authService.registerMember(member);
		
		//3. 응답 컨텐츠 생산 ( JSP로 forward or Servlet으로 redirect )
		resp.sendRedirect("login.action");
		
	}
}
