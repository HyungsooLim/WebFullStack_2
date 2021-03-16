package com.hs.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.s1.util.ActionFoward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
		MemberDAO memberDAO = new MemberDAO();
		memberService.setMemberDAO(memberDAO);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Member Controller");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String result="";
		//subString
		int idx = uri.lastIndexOf("/");
		result = uri.substring(idx+1);
		System.out.println(result);
		String pathInfo = "";
		ActionFoward actionFoward=null;
		
		if(result.equals("memberLogin.do")) {
			try {
				actionFoward=memberService.memberLogin(request);
				System.out.println("로그인 성공");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if(result.equals("memberJoin.do")) {
			try {
				actionFoward =memberService.memberJoin(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			System.out.println("그 외 다른 처리");
		}
		
		//forward
		RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
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
