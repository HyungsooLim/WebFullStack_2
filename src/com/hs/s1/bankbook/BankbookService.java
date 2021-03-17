package com.hs.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hs.s1.util.ActionForward;

public class BankbookService {

	private BankbookDAO bankbookDAO;
	ActionForward actionForward;
	
	public BankbookService() {
		actionForward=new ActionForward();
	}

	public void setBankbookDAO(BankbookDAO bankbookDAO) {
		this.bankbookDAO = bankbookDAO;
	}

	// getList
	// DAO의 getList 호출 후 actionforward 리턴
	public ActionForward getList(HttpServletRequest request) throws Exception {
		List<BankbookDTO> ar = bankbookDAO.getList();
		request.setAttribute("list", ar);
		actionForward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		actionForward.setCheck(true);

		return actionForward;
	} // === getList method END ===

	public ActionForward getSelect(HttpServletRequest request) throws Exception {
		BankbookDTO bankbookDTO = new BankbookDTO();
		
		bankbookDTO.setBookNumber(Long.parseLong(request.getParameter("bookNumber")));
		bankbookDTO =bankbookDAO.getSelect(bankbookDTO);
		request.setAttribute("DTO", bankbookDTO);
		actionForward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
		actionForward.setCheck(true);
		
		
		return actionForward;
	} // === getSelect method END ===

}
