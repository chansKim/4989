package com.ju.chan;

import java.util.*;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.ju.chan.dto.*;
import com.ju.chan.member.service.*;
import com.ju.chan.pds.service.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired	
	private ICustPDSService iCustPDSService;
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);

		
		
		return "index";
	}
	
	
	@RequestMapping(value = "/{wcust}/home.do", method ={ RequestMethod.POST, RequestMethod.GET })
	public String home(@PathVariable String wcust, HttpSession session,ResourceDto resourceDto,ScrapDto scrapDto,
			HttpServletRequest request, Locale locale, MemberDto memberDto, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		memberDto = (MemberDto) session.getAttribute("login");
		memberDto = memberService.login(memberDto);
		
		////
//		List<FollowDto> fList = iCustPDSService.getFollow(memberDto.getM_mail());
//		ArrayList<ResourceDto> rList = new ArrayList<ResourceDto>();
//		for (int i = 0; i < fList.size(); i++) {
//			rList.add(iCustPDSService.getResourceFollow(fList.get(i)));
//		}
//		model.addAttribute("mymymy",rList);

		
		
		////
		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String , String> maps = new HashMap<String, String>();

		if(p != null){
			if(p.equals("complete")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("buy")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("sell")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("all")){
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource2(memberDto));
			} 
		} else {
			model.addAttribute("follow_resource",iCustPDSService.getFollowResource2(memberDto));
		}
		
		if (memberService.login(memberDto) != null) {
			model.addAttribute("mblist",iCustPDSService.getPDSList(memberDto));
			model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
			model.addAttribute("keyword_my",iCustPDSService.getKeyword(memberDto));
			model.addAttribute("get_myscrap",iCustPDSService.getMyScrap(memberDto));

		} 
		else {
			logger.info("Welcome 4989 " + new Date());
			session.invalidate();
		}
		return wcust + "/home";
	}
	
	@RequestMapping(value = "/{wcust}/home_baduk.do", method ={ RequestMethod.POST, RequestMethod.GET })
	public String home_baduk(@PathVariable String wcust, HttpServletRequest request,
			HttpSession session, Locale locale, MemberDto memberDto, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		memberDto = (MemberDto) session.getAttribute("login");
		memberDto = memberService.login(memberDto);
		
		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String , String> maps = new HashMap<String, String>();

		if(p != null){
			if(p.equals("complete")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("buy")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("sell")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("all")){
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource2(memberDto));
			} 
		} else {
			model.addAttribute("follow_resource",iCustPDSService.getFollowResource2(memberDto));
		}
		
		if (memberService.login(memberDto) != null) {
			model.addAttribute("mblist",iCustPDSService.getPDSList(memberDto));
			model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
			model.addAttribute("keyword_my",iCustPDSService.getKeyword(memberDto));
			model.addAttribute("get_myscrap",iCustPDSService.getMyScrap(memberDto));

			logger.info("Welcome MemCtrl LoginPage!");

		} 
		else {
			logger.info("Welcome 4989 " + new Date());
			session.invalidate();
		}
		return wcust + "/home_baduk";
	}
	
	@RequestMapping(value = "/{wcust}/home_list.do", method ={ RequestMethod.POST, RequestMethod.GET })
	public String home_list(@PathVariable String wcust, HttpServletRequest request,
			HttpSession session, Locale locale, MemberDto memberDto, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		memberDto = (MemberDto) session.getAttribute("login");
		memberDto = memberService.login(memberDto);
		
		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String , String> maps = new HashMap<String, String>();

		if(p != null){
			if(p.equals("complete")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("buy")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("sell")){
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource(maps));
			}else if (p.equals("all")){
				model.addAttribute("follow_resource",iCustPDSService.getFollowResource2(memberDto));
			} 
		} else {
			model.addAttribute("follow_resource",iCustPDSService.getFollowResource2(memberDto));
		}
		
		if (memberService.login(memberDto) != null) {
			model.addAttribute("mblist",iCustPDSService.getPDSList(memberDto));
			model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
			model.addAttribute("keyword_my",iCustPDSService.getKeyword(memberDto));
			model.addAttribute("get_myscrap",iCustPDSService.getMyScrap(memberDto));

			logger.info("Welcome MemCtrl LoginPage!");

		} 
		else {
			session.invalidate();
		}
		return wcust + "/home_list";
	}
	
	@RequestMapping(value = "/{wcust}/logout.do", method = RequestMethod.GET)
	public String logout(@PathVariable String wcust, HttpSession session, MemberDto memberDto, Model model) {
		logger.info("Welcome LOGOUT! " + new Date());
		session.invalidate();
		return wcust + "/loginSession";
	}

}
