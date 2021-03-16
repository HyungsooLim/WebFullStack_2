package com.hs.s1.test;

import com.hs.s1.member.MemberDAO;
import com.hs.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		// Web에서 메인 method는 테스트 용도로만 사용
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("id1");
//		memberDTO.setPw("pw1");
//		try {
//			memberDTO = memberDAO.login(memberDTO);
//			System.out.println(memberDTO != null);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		memberDTO.setId("id3");
		memberDTO.setPw("pw3");
		memberDTO.setName("name3");
		memberDTO.setPhone("010-3333-3333");
		memberDTO.setEmail("name3@google.com");
		
		try {
			memberDAO.memberJoin(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} // === MAIN END ===
}
