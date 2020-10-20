package com.jiseung.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiseung.s3.MyTestCase;

public class MemberDAOTest extends MyTestCase {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void memberSelectTest() throws Exception{
		MemberDTO memberDTO = memberDAO.memberSelect(15);
		
		assertNotNull(memberDTO);
	}
	
	
	//----------------------------------------------------------------------
	
		@Test
		public void memberJoinTest() throws Exception{
			for(int i=0;i<100;i++) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId("id_test"+i);
				memberDTO.setPw("pw_test"+i);
				memberDTO.setName("jung_test"+i);
				memberDTO.setEmail("test"+i+"@test.com");
				int result = memberDAO.memberJoin(memberDTO);
				
				if(i%10==0) {
					Thread.sleep(1000);
				}
		
			}
		}
	

}
