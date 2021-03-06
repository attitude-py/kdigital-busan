package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/handle-request" })
public class HandleRequestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get request data encoding : default utf-8
		
		String name = req.getParameter("name"); // name="name"인 입력 요소의 데이터 읽기
		String email = req.getParameter("email"); // name="email"인 입력 요소의 데이터 읽기
		
		System.out.printf("GET REQUEST : [%s][%s]\n", name, email); // 서버의 콘솔에 출력
	
		// html text 형식으로 응답
		resp.setContentType("text/html;charset=utf-8"); //브라우저에게 이 응답이 html 형식이며 utf-8 방식으로 작성된 것을 알려주는 설정
		PrintWriter out = resp.getWriter();
		String message = String.format("<h2>GET RESPONSE : [%s][%s]</h2>", name, email);
		out.println(message); // 응답 스트림에 데이터 쓰기 --> 브라우저에게 전달
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// post request data encoding : default ascii -> 한글 데이터를 읽으려면 encoding 수정 필요
		req.setCharacterEncoding("utf-8"); // 요청 데이터를 읽을 때 사용할 인코딩 지정
		String name = req.getParameter("name"); // name="name"인 입력 요소의 데이터 읽기
		String email = req.getParameter("email"); // name="email"인 입력 요소의 데이터 읽기
		
		System.out.printf("POST REQUEST : [%s][%s]\n", name, email); // 서버의 콘솔에 출력
	
		// html text 형식으로 응답
		resp.setContentType("text/html;charset=utf-8"); //브라우저에게 이 응답이 html 형식이며 utf-8 방식으로 작성된 것을 알려주는 설정
		PrintWriter out = resp.getWriter();
		String message = String.format("<h2>POST RESPONSE : [%s][%s]</h2>", name, email);
		out.println(message); // 응답 스트림에 데이터 쓰기 --> 브라우저에게 전달
		
		
	}

}










