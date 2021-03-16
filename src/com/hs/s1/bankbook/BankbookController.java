package com.hs.s1.bankbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankbookController
 */
@WebServlet("/BankbookController")
public class BankbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//memberController 참조
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String result = uri.substring(idx+1);
		if(result.equals("bankList.do")) {
			BankbookService bankbookService = new BankbookService();
			try {
				List<BankbookDTO> ar = bankbookService.getList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher view = request.getRequestDispatcher("./bankbookList.jsp");
		view.forward(request, response);
		
		
	} // === doGet method END ===

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
