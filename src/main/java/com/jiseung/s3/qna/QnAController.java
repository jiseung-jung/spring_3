package com.jiseung.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jiseung.s3.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnAController {
	
	@Autowired
	private QnAService qnaService; 
	
	@RequestMapping(value = "qnaList")
	public ModelAndView qnaList(Pager pager) throws Exception{
		List<QnADTO> ar = qnaService.qnaList(pager);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/qnaList");
		
		return mv;
	}
	
	//------------------------------------------------------------------------------
	
	@RequestMapping(value = "qnaSelect")
	public void qnaSelect(long num, Model model) throws Exception {
		QnADTO qnaDTO =qnaService.qnaSelect(num);
		model.addAttribute("dto", qnaDTO);
	}
	
	//------------------------------------------------------------------------------
	
	@RequestMapping(value = "qnaWrite")
	public void qnaWrite() {
		
	}
	
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public String qnaWrite(QnADTO qnaDTO) throws Exception {
		int result = qnaService.qnaWrite(qnaDTO);
		
		return "redirect:./qnaList";
	}
	
	//------------------------------------------------------------------------------
	
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView qnaDelete(long num) throws Exception {
		int result = qnaService.qnaDelete(num);
		
		ModelAndView mv = new ModelAndView();
		
		String msg = "Delete Fail";
		
		if(result>0) {
			msg="Delete Success";
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg",msg);
		mv.addObject("path", "./qnaList");
		
		return mv;
	}
	
	//------------------------------------------------------------------------------
	
	@RequestMapping(value = "qnaUpdate")
	public void qnaUpdate(QnADTO qnaDTO, Model model) throws Exception{
		qnaDTO = qnaService.qnaSelect(qnaDTO.getNum());
		
		model.addAttribute("updto", qnaDTO);
	}
	
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView qnaUpdate(QnADTO qnaDTO) throws Exception {
		int result = qnaService.qnaUpdate(qnaDTO);
		
		ModelAndView mv = new ModelAndView();
		
		String msg = "Update Fail";
		
		if(result>0) {
			msg="Update Success";
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg",msg);
		mv.addObject("path", "./qnaSelect");
		
		return mv;
	}
	
	//------------------------------------------------------------------------------

	@RequestMapping(value = "qnaReply")
	public void qnaReply() throws Exception {
	
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView qnaReply(QnADTO qnaDTO) throws Exception {
		int result = qnaService.qnaReply(qnaDTO);
		
		ModelAndView mv = new ModelAndView();
		
		String msg = "Reply Write Fail";
		
		if(result>0) {
			msg="Reply Write Success";
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		
		return mv;
	}
}









