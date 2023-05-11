package com.ju.chan;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ReplyDto;
import com.ju.chan.dto.ResourceDto;
import com.ju.chan.member.service.IMemberService;
import com.ju.chan.member.service.ReplyService;

import javax.servlet.http.HttpSession;
import com.ju.chan.dto.*;
import com.ju.chan.dto.*;
import com.ju.chan.dto.*;

@Controller
public class ReplyController {	
	/*
	@RequestMapping(value = "/{wcust}/replyList.do", method ={ RequestMethod.POST, RequestMethod.GET })
	public void replyList() {
		System.out.println("Controller");
	}
	*/
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/{wcust}/replyAdd.do", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String replyAdd(@RequestParam("r_content") String r_content,
			@RequestParam("r_id") int r_id, @RequestParam("r_flag") boolean r_flag, HttpSession session, String model) {
		
		int r_flag_no = (r_flag)?1:0;	//비밀댓글 체크 되었으면 1, 아니면 0
		
		MemberDto memberDto = (MemberDto) session.getAttribute("login");
		String m_mail = memberDto.getM_mail();
		
		ReplyDto replyDto = new ReplyDto();
		replyDto.setM_mail(m_mail);
		replyDto.setR_id(r_id);	//포스트 아이디	//임의 값
		replyDto.setContent(r_content);
		replyDto.setSecretType(r_flag_no);
		
		replyService.replyAdd(replyDto);
		
		return model;
	}
	
	@RequestMapping(value="/{wcust}/replyList.do", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ReplyDto> replyList(@RequestParam("r_id") int r_id) {

		List<ReplyDto> rlist = replyService.getReplyList(r_id);
		TIME_MAXIMUM tm = new TIME_MAXIMUM();

		for (int i = 0; i < rlist.size(); i++) {
			rlist.get(i).setMtime(tm.calculateTime(rlist.get(i).getCtime()));;
		}
		return rlist;
	}
	
	@RequestMapping(value="/{wcust}/open_phone.do", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<MemberDto> open_phone(@RequestParam("m_mail") String m_mail, HttpSession session, String model,
			ResourceDto resourceDto, MemberDto memberDto) {
		
		resourceDto.setM_mail(m_mail);
//		System.out.println("m_mail : " + m_mail);
		List<MemberDto> list = replyService.open_phone(resourceDto);
		
		return list;
	}
	
	@RequestMapping(value="/{wcust}/replyDelete.do", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String replyDelete(@RequestParam("id") int id, HttpSession session, String model) {
		
		replyService.replyDelete(id);
		
		return model;
	}
}

