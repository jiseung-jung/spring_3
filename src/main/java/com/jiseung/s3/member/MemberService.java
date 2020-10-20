package com.jiseung.s3.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiseung.s3.notice.NoticeDTO;
import com.jiseung.s3.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> memberList(Pager pager) throws Exception {
		//**rownum 계산
		pager.makeRow();
		
	//**page 계산
	long totalCount = memberDAO.memberCount();
	pager.setTotalCount(totalCount);
	pager.makePage();
	return memberDAO.memberList(pager);
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberJoin(memberDTO);
	}
	
	public MemberDTO memberSelect(long num) throws Exception{
		return memberDAO.memberSelect(num);
	}
	
	public int memberDelete(long num) throws Exception{
		return memberDAO.memberDelete(num);
	}

}
