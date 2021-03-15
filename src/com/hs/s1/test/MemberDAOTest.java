package com.hs.s1.test;

import com.hs.s1.member.MemberDAO;
import com.hs.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		// Web에서 메인 method는 테스트 용도로만 사용
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		try {
			memberDTO = memberDAO.login(memberDTO);
			System.out.println(memberDTO != null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
