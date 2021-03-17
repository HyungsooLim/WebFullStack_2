package com.hs.s1.test;

import java.util.List;

import com.hs.s1.bankbook.BankbookDAO;
import com.hs.s1.bankbook.BankbookDTO;

public class BankbookDAOTest {

	public static void main(String[] args) {
		BankbookDAO bankbookDAO = new BankbookDAO();
		BankbookDTO bankbookDTO = new BankbookDTO();
//		try {
//			List<BankbookDTO> ar = bankbookDAO.getList();
//			System.out.println(ar.size()==4);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			bankbookDTO.setBookNumber(1);
			bankbookDTO =bankbookDAO.getSelect(bankbookDTO);
			if(bankbookDTO!=null) {
				System.out.println(bankbookDTO.getBookNumber());
				System.out.println(bankbookDTO.getBookName());
				System.out.println(bankbookDTO.getBookRate());
				System.out.println(bankbookDTO.getBookSale());
			}else {
				System.out.println("검색 결과 없음");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
