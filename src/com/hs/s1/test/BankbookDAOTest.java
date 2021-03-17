package com.hs.s1.test;

import java.util.List;

import com.hs.s1.bankbook.BankbookDAO;
import com.hs.s1.bankbook.BankbookDTO;

public class BankbookDAOTest {

	public static void main(String[] args) {
		BankbookDAO bankbookDAO = new BankbookDAO();
		try {
			List<BankbookDTO> ar = bankbookDAO.getList();
			System.out.println(ar.size()==4);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
