package com.hs.s1.bankbook;

import java.util.List;

public class BankbookService {

	//getList
	//DAO의 getList 호출 후 actionforward 리턴
	public List<BankbookDTO> getList() throws Exception {
		BankbookDAO bankbookDAO = new BankbookDAO();
		List<BankbookDTO> ar =bankbookDAO.getList();
		
		return ar;
	} // === getList method END ===
	
}
