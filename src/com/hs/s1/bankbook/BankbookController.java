package com.hs.s1.bankbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.s1.util.ActionForward;

/**
 * Servlet implementation class BankbookController
 */
@WebServlet("/BankbookController")
public class BankbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankbookService bankbookService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankbookController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		// Controller 객체 생성 후 자동 호출 되는 초기화 메서드
		bankbookService = new BankbookService();
		BankbookDAO bankbookDAO = new BankbookDAO();
		bankbookService.setBankbookDAO(bankbookDAO);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// memberController 참조
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);
		ActionForward actionForward = null;
		try {
			if (uri.equals("bankbookList.do")) {
				actionForward = bankbookService.getList(request);
			} else if (uri.equals("bankbookSelect.do")) {
				actionForward = bankbookService.getSelect(request);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// forward, redirect
		if (actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		} else {
			response.sendRedirect(actionForward.getPath());
		}

	} // === doGet method END ===

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
