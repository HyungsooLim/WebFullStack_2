package com.hs.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Member Controller");
		
		String path = request.getServletPath();
		String uri = request.getRequestURI();
		System.out.println(path);
		System.out.println(uri);
		String result="";
		//subString
		int idx = uri.lastIndexOf("/");
		result = uri.substring(idx+1);
		System.out.println(result);
		String pathInfo = "";
		if(result.equals("memberLogin.do")) {
			System.out.println("로그인 처리");
			pathInfo="../WEB-INF/member/memberLogin.jsp";
		}else if(result.equals("memberJoin.do")) {
			System.out.println("회원가입 처리");
			pathInfo="../WEB-INF/member/memberJoin.jsp";
		}else {
			System.out.println("그 외 다른 처리");
		}
		
		//forward
		RequestDispatcher view = request.getRequestDispatcher(pathInfo);
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
