package com.jiseung.s3.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.s3.notice.NoticeDTO;
import com.jiseung.s3.util.Pager;

@Controller
@RequestMapping(value = "/member/**")
public class MemberContoller {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberList")
	public ModelAndView memberList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
//		Pager pager = new Pager();
//		pager.setLastRow(curPage*10);
//		pager.setStartRow((curPage-1)*10+1);
		
		List<MemberDTO> ar = memberService.memberList(pager);
		
//		// 1. 전체 글의 갯수 조회
//		long totalCount = pager.getTotalCount();
//		
//		
//		// 2. 전체 페이지의 갯수
//			long totalPage = totalCount/10;
//			if(totalCount%10 !=0) {
//				totalPage++;
//		}
//		
//		
//		//3. 전체 블럭의 갯수 구하기
//			long totalBlock = totalPage/5;
//			if(totalPage%5 !=0) {
//				totalBlock++;
//			}
//		
//		
//		//4. curPage를 이용해서 현재 블럭 번호 찾기
//			long curBlock = curPage/5;
//			if(curPage%5 !=0) {
//				curBlock++;
//			}
//		
//		
//		//5. 현재 블럭 번호로 시작 번호, 끝 번호 계산
//			long startNum = (curBlock-1)*5+1;
//			long lastNum = curBlock*5;
//		
//		
//		
//		//6. 현재 블럭번호와 전체 블럭번호가 같은지 결정
//		boolean nextCheck=true;
//		if(curBlock==totalBlock) {
//			nextCheck = !nextCheck;
//			lastNum = totalPage;
//		}
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
//		mv.addObject("startNum", startNum);
//		mv.addObject("lastNum", lastNum);
//		mv.addObject("nextCheck", nextCheck);
//		mv.addObject("count", totalCount/10);
		mv.setViewName("member/memberList");
		
		return mv;
		
	}
	
	
	//---------------------------------------------------------------------------------------
	
	@RequestMapping(value = "memberJoin")
	public void memberJoin() {}
	
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception {
		System.out.println("Member Join");
		int result = memberService.memberJoin(memberDTO);
	
		return "redirect:./memberList";
	}
	
	

	//---------------------------------------------------------------------------------------
	
	@RequestMapping(value = "memberSelect")
	public void memberSelect(long num, Model model) throws Exception {
		MemberDTO memberDTO = memberService.memberSelect(num);
		
		model.addAttribute("select", memberDTO);
	}
	
	//---------------------------------------------------------------------------------------
	
	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(long num) throws Exception{
		int result = memberService.memberDelete(num);
		String message="Delete Fail";
		
		if(result>0) {
			message="Delete Success";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./memberList");
		
		
		return mv;
	}
}
