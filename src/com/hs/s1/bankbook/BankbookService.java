package com.hs.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hs.s1.util.ActionForward;

public class BankbookService {

	private BankbookDAO bankbookDAO;

	public void setBankbookDAO(BankbookDAO bankbookDAO) {
		this.bankbookDAO = bankbookDAO;
	}

	// getList
	// DAO의 getList 호출 후 actionforward 리턴
	public ActionForward getList(HttpServletRequest request) throws Exception {
		ActionForward actionForward = new ActionForward();
		List<BankbookDTO> ar = bankbookDAO.getList();
		request.setAttribute("list", ar);
		actionForward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		actionForward.setCheck(true);

		return actionForward;
	} // === getList method END ===

}
