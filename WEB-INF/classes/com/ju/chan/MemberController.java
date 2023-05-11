package com.ju.chan;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ju.chan.dto.*;
import com.ju.chan.member.service.IMemberService;
import com.ju.chan.pds.service.ICustPDSService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory
			.getLogger(MemberController.class);

	@Autowired
	private IMemberService memberService;
	@Autowired
	private ICustPDSService iCustPDSService;

	@RequestMapping(value = "/{wcust}/join.do", method = RequestMethod.POST)
	public String join(@PathVariable String wcust, MemberDto memberDto,
			Model model) {
		logger.info("Welcome MemCtrl LoginPage! " + memberDto);

		return wcust + "/join";
	}

	@RequestMapping(value = "/{wcust}/login.do", method = RequestMethod.POST)
	public String login(@PathVariable String wcust, MemberDto memberDto,
			FollowDto followDto, Model model) {
		logger.info("Welcome MemCtrl LoginPage! " + memberDto);

		followDto.setM_mail(memberDto.getM_mail());
		followDto.setFace_mail("ADMIN");

		if (memberService.memberAdd(memberDto, followDto)) {
			return wcust + "/login";
		} else {
			model.addAttribute("fail", "1");

			return wcust + "join";
		}
	}

	@RequestMapping(value = "/{wcust}/loginGo.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String loginGo(@PathVariable String wcust, Model model) {
		logger.info("Welcome MemCtrl LoginPage! ");

		return wcust + "/login";
	}

	@RequestMapping(value = "/{wcust}/withdrawal.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	String withdrawal(@RequestParam("m_mail") String m_mail,
			@PathVariable String wcust, MemberDto memberDto,
			HttpSession session, Model model) {
		logger.info("Welcome MemCtrl Withdrawal! ");

		memberService.withdrawal(memberDto);
		session.invalidate();

		return wcust + "/join";
	}

	@RequestMapping(value = "/{wcust}/loginaf.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String login(@PathVariable String wcust, HttpServletRequest request,
			HttpSession session, MemberDto memberDto, Model model) {
		memberDto = memberService.login(memberDto);

		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String, String> maps = new HashMap<String, String>();

		if (p != null) {
			if (p.equals("complete")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("buy")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("sell")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("all")) {
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource2(memberDto));
			}
		} else {
			model.addAttribute("follow_resource",
					iCustPDSService.getFollowResource2(memberDto));
		}

		if (memberService.login(memberDto) != null) {
			session.setAttribute("login", memberDto);
			session.setMaxInactiveInterval(30 * 600);
			model.addAttribute("mblist", iCustPDSService.getPDSList(memberDto));
			model.addAttribute("resource",
					iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",
					iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",
					iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",
					iCustPDSService.getMyProfile(memberDto));
			model.addAttribute("keyword_my",
					iCustPDSService.getKeyword(memberDto));
			model.addAttribute("get_myscrap",
					iCustPDSService.getMyScrap(memberDto));

			logger.info("login" + memberDto.getM_mail());

			return wcust + "/home";
		} else {
			logger.info("login fail " + new Date());
			session.invalidate();

			model.addAttribute("fail", "1");

			return wcust + "/login";
		}
	}

	@RequestMapping(value = "/{wcust}/dashboard.do", method = RequestMethod.GET)
	public String dashboard(@PathVariable String wcust, HttpSession session,
			MemberDto memberDto, Model model) {
		MemberDto login = memberService.login(memberDto);

		if (memberService.login(memberDto) != null) {
			session.setAttribute("login", login);
			session.setMaxInactiveInterval(30 * 600);
			model.addAttribute("mblist", iCustPDSService.getPDSList(memberDto));
			logger.info("ss" + iCustPDSService.getPDSList(memberDto).toString());
		}

		else {
			logger.info("Login fail 4989 " + new Date());
			session.invalidate();
		}
		return wcust + "/home";
	}

	@RequestMapping(value = "/member/pdslistGET.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<?, ?> AjaxViewGET(@RequestParam Map<String, Object> paramMap,
			ModelMap model) {
		model.put("pdslist", iCustPDSService.getPdsListTest());
		return model;
	}

	@RequestMapping(value = "/ajaxviewPOST.do", method = RequestMethod.GET)
	public @ResponseBody
	List<ResourceDto> AjaxViewPOST(@RequestParam("member") MemberDto user) {

		List<ResourceDto> rlist = iCustPDSService.getPDSList(user);
		return rlist;
	}

	@RequestMapping(value = "/{wcust}/mypage.do", method = RequestMethod.GET)
	public String mypage(@PathVariable String wcust, HttpSession session,
			MemberDto memberDto, Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		memberDto = memberService.login(memberDto);
		session.setAttribute("login", memberDto);
		session.setMaxInactiveInterval(30 * 600);

		logger.info("Welcome MemCtrl mypage!!! " + memberDto);
		model.addAttribute("r_name", iCustPDSService.getMyProfile(memberDto));

		return wcust + "/mypage";
	}

	@RequestMapping(value = "/{wcust}/myPost.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String myPost(@PathVariable String wcust, ResourceDto resourceDto,
			HttpSession session, HttpServletRequest request,
			MemberDto memberDto, Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		memberDto = memberService.login(memberDto);
		session.setAttribute("login", memberDto);
		session.setMaxInactiveInterval(30 * 600);

		String face_mail = request.getParameter("face_mail");
		System.out.println("face_mail : " + face_mail);
		if (face_mail != null) {
			MemberDto faceDto = new MemberDto();
			faceDto.setM_mail(face_mail);
			model.addAttribute("resource",
					iCustPDSService.getResource_Mine(faceDto));//
		} else {
			model.addAttribute("resource",
					iCustPDSService.getResource_Mine(memberDto));//
		}

		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String, String> maps = new HashMap<String, String>();

		if (p != null) {
			if (p.equals("complete")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("buy")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("sell")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("all")) {
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource2(memberDto));
			}
		} else {
			model.addAttribute("follow_resource",
					iCustPDSService.getFollowResource2(memberDto));
		}

		if (memberService.login(memberDto) != null) {
			model.addAttribute("mblist", iCustPDSService.getPDSList(memberDto));
			model.addAttribute("follow",
					iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",
					iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",
					iCustPDSService.getMyProfile(memberDto));
			model.addAttribute("get_myscrap",
					iCustPDSService.getMyScrap(memberDto));

		} else {
			logger.info("Welcome 4989 " + new Date());
			session.invalidate();
		}

		return wcust + "/myPost";
	}

	@RequestMapping(value = "/{wcust}/myFollow.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String myFollow(@PathVariable String wcust, ResourceDto pdsdto,
			HttpServletRequest request, HttpSession session,
			ResourceDto resourceDto, MemberDto memberDto, Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		logger.info("Welcome MemCtrl myFollow!!! " + resourceDto);
		model.addAttribute("follow",
				iCustPDSService.getFollow(memberDto.getM_mail()));
		model.addAttribute("keyword_my", iCustPDSService.getKeyword(memberDto));

		return wcust + "/myFollow";
	}

	@RequestMapping(value = "/{wcust}/myKeyword.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String myKeyword(@PathVariable String wcust, ResourceDto pdsdto,
			HttpServletRequest request, HttpSession session,
			ResourceDto resourceDto, MemberDto memberDto, Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		logger.info("Welcome MemCtrl myKeyword!!! " + resourceDto);
		model.addAttribute("follow",
				iCustPDSService.getFollow(memberDto.getM_mail()));
		model.addAttribute("keyword_all",
				iCustPDSService.getKeyword_all(memberDto));
		model.addAttribute("keyword_my", iCustPDSService.getKeyword(memberDto));

		return wcust + "/myKeyword";
	}

	@RequestMapping(value = "/{wcust}/search_keyword.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String search_keyword(@PathVariable String wcust,
			ResourceDto pdsdto,
			@RequestParam("search_keyword") String search_keyword,
			KeywordDto keywordDto, FollowDto followDto, HttpSession session,
			MemberDto memberDto, Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		logger.info("Welcome MemCtrl myKeyword!!! " + search_keyword);

		Map<String, String> maps = new HashMap<String, String>();

		maps.put("search_keyword", search_keyword);
		maps.put("m_mail", memberDto.getM_mail());
		List<FollowDto> list = iCustPDSService.getMyKeyword(maps);
		if (list.size() == 0) {
			// iCustPDSService.setKeyword_search(search_keyword);
			followDto.setM_mail(memberDto.getM_mail());
			followDto.setK_name(search_keyword);

			logger.info("Welcome MemCtrl myKeyword!!! " + followDto.toString());

			iCustPDSService.setFollow_keyword(followDto);
		}

		model.addAttribute("follow",
				iCustPDSService.getFollow(memberDto.getM_mail()));
		model.addAttribute("keyword_all",
				iCustPDSService.getKeyword_all(memberDto));
		model.addAttribute("keyword_my", iCustPDSService.getKeyword(memberDto));

		return wcust + "/myKeyword";
	}

	// 메세지 보낼 아이디 검색
	@RequestMapping(value = "/{wcust}/search_email.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	int search_email(@RequestParam("face_mail") String search_keyword) {

		int su = iCustPDSService.getSearchEmail(search_keyword); // 이메일 주소가 있으면
																	// su가 1 없으면
																	// 0

		return su;
	}

	// 메세지 보내기
	@RequestMapping(value = "/{wcust}/send_message.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String send_message(@PathVariable String wcust,
			MessageDto messagedto, MemberDto memberDto, HttpSession session,
			Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		logger.info("Welcome MemCtrl myKeyword!!! ");
		messagedto.setM_mail(memberDto.getM_mail());
		iCustPDSService.sendMessage(messagedto);

		model.addAttribute("get_myMessage",
				iCustPDSService.getMyMessage(memberDto));
		model.addAttribute("receive_message",
				iCustPDSService.getSendMessage(memberDto));

		return wcust + "/myReceiveMessage";
	}

	// 신고 보내기
	@RequestMapping(value = "/{wcust}/send_report.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	String send_report(@RequestParam("r_id") int r_id,
			@RequestParam("e_content") String e_content,
			@PathVariable String wcust, ReportDto reportDto,
			MemberDto memberDto, HttpSession session, Model model,
			HttpServletRequest request) {
		String result = "a";
		System.out.println("dsafhasjldfhasljdfflsk");

		memberDto = (MemberDto) session.getAttribute("login");
		logger.info("Welcome MemCtrl myKeyword!!! ");
		reportDto.setM_mail(memberDto.getM_mail());
		// iCustPDSService.sendReport(reportDto);

		reportDto.setR_id(r_id);
		reportDto.setE_content(e_content);
		System.out.println("report : " + reportDto.getE_id());
		iCustPDSService.sendReport(reportDto);

		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String, String> maps = new HashMap<String, String>();

		if (p != null) {
			if (p.equals("complete")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("buy")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("sell")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("all")) {
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource2(memberDto));
			}
		} else {
			model.addAttribute("follow_resource",
					iCustPDSService.getFollowResource2(memberDto));
		}

		if (memberService.login(memberDto) != null) {
			model.addAttribute("mblist", iCustPDSService.getPDSList(memberDto));
			model.addAttribute("resource",
					iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",
					iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",
					iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",
					iCustPDSService.getMyProfile(memberDto));
			model.addAttribute("keyword_my",
					iCustPDSService.getKeyword(memberDto));
			model.addAttribute("get_myscrap",
					iCustPDSService.getMyScrap(memberDto));

		} else {
			logger.info("Welcome 4989 " + new Date());
			session.invalidate();
		}
		// return wcust + "/home";
		return result;
	}

	@RequestMapping(value = "/{wcust}/deletePost.do", method = RequestMethod.GET)
	public String deletePost(@PathVariable String wcust, ResourceDto pdsdto,
			HttpServletRequest request, HttpSession session,
			ResourceDto resourceDto, MemberDto memberDto, Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		logger.info("Welcome MemCtrl mypage!!! " + resourceDto);

		pdsdto.setM_mail(memberDto.getM_mail());
		String root = session.getServletContext().getRealPath("/");//
		String fupload = root + "upload/" + resourceDto.getR_name();

		File f1 = new File(fupload);

		if (f1.exists()) {
			boolean deleteFlag = f1.delete();

			if (deleteFlag) {
				System.out.println("파일 삭제 완료 ");
			} else {
				System.out.println("파일 삭제 실패 ");
			}
		} else {
			System.out.println("파일이 존재하지 않음");
		}

		System.out.println(pdsdto);

		iCustPDSService.deletePost(pdsdto);

		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String, String> maps = new HashMap<String, String>();

		if (p != null) {
			if (p.equals("complete")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("buy")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("sell")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("all")) {
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource2(memberDto));
			}
		} else {
			model.addAttribute("follow_resource",
					iCustPDSService.getFollowResource2(memberDto));
		}

		model.addAttribute("resource",
				iCustPDSService.getResource_Mine(memberDto));
		model.addAttribute("follow",
				iCustPDSService.getFollow(memberDto.getM_mail()));
		model.addAttribute("recommand",
				iCustPDSService.getRecommand(memberDto.getM_mail()));
		model.addAttribute("r_name", iCustPDSService.getMyProfile(memberDto));

		return wcust + "/myPost";
	}

	@RequestMapping(value = "/{wcust}/mainPicturd_upload.do", method = RequestMethod.POST)
	public String mainPicturd_upload(
			@PathVariable String wcust,
			ResourceDto resDto,
			MemberDto memberDto,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "fileload", required = true) MultipartFile fileload,
			Model model) {

		memberDto = (MemberDto) session.getAttribute("login");
		String m_mail = memberDto.getM_mail();

		Map<String, ResourceDto> maps = new HashMap<String, ResourceDto>();

		resDto.setM_mail(m_mail);

		resDto.setR_name(fileload.getOriginalFilename());

		logger.info("Welcome SongController pdsdto! " + resDto);

		String root = session.getServletContext().getRealPath("/");//
		String fupload = root + "upload";
		System.out.println("path : " + fupload);

		String f = resDto.getR_name();

		// name = new String(name.getBytes("8859_1"),"euc-kr");

		String newFile = FUpUtil.getNewFile(f);
		logger.info(fupload + "/" + newFile);
		resDto.setR_name(newFile);
		maps.put("resDto", resDto);

		try {
			File file = new File(fupload + "/" + newFile);
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			memberService.uploadMainPic(resDto);
			logger.info("Welcome pdsupload success! ");
		} catch (IOException e) {
			logger.info("Welcome pdsupload fail! ");
		}
		return wcust + "/mypage";
	}

	@RequestMapping(value = "/{wcust}/mymessage.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String myMessage(@PathVariable String wcust, HttpSession session, HttpServletRequest request,
			MessageDto messagedto, MemberDto memberDto, Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		logger.info("Welcome MemCtrl myKeyword!!! ");
		logger.info("받앗다~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
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
		model.addAttribute("get_myMessage",
				iCustPDSService.getMyMessage(memberDto));
		model.addAttribute("receive_message",
				iCustPDSService.getSendMessage(memberDto));
		model.addAttribute("mblist",iCustPDSService.getPDSList(memberDto));
		model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
		model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
		model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
		model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
		model.addAttribute("keyword_my",iCustPDSService.getKeyword(memberDto));
		model.addAttribute("get_myscrap",iCustPDSService.getMyScrap(memberDto));

		return wcust + "/myReceiveMessage";
	}

	@RequestMapping(value = "/{wcust}/myScrap.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String myScrap(@PathVariable String wcust, HttpSession session,
			ScrapDto scrapDto, ResourceDto resourceDto, Model model,
			HttpServletRequest request) {

		logger.info("스크랩함으로 왔다~~~~~~~~~~~");

		MemberDto memberDto = (MemberDto) session.getAttribute("login");

		memberDto = memberService.login(memberDto);
		session.setAttribute("login", memberDto);
		session.setMaxInactiveInterval(30 * 600);

		memberDto = memberService.login(memberDto);
		if (request.getParameter("r_id") != null) {
			scrapDto.setM_mail(memberDto.getM_mail());
			scrapDto.setR_id(Integer.parseInt(request.getParameter("r_id")));
			iCustPDSService.setMyScrap(scrapDto);
		}

		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String, String> maps = new HashMap<String, String>();

		if (p != null) {
			if (p.equals("complete")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "3");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("buy")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "2");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("sell")) {
				maps.put("m_mail", memberDto.getM_mail());
				maps.put("post_type", "1");
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource(maps));
			} else if (p.equals("all")) {
				model.addAttribute("follow_resource",
						iCustPDSService.getFollowResource2(memberDto));
			}
		} else {
			model.addAttribute("follow_resource",
					iCustPDSService.getFollowResource2(memberDto));
		}

		if (memberService.login(memberDto) != null) {
			model.addAttribute("mblist", iCustPDSService.getPDSList(memberDto));
			model.addAttribute("resource",
					iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",
					iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",
					iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",
					iCustPDSService.getMyProfile(memberDto));
			model.addAttribute("get_myscrap",
					iCustPDSService.getMyScrap(memberDto));

		} else {
			logger.info("Welcome Tumblr " + new Date());
			session.invalidate();
		}

		return wcust + "/myScrap";
	}

	@RequestMapping(value = "/{wcust}/mySendMessage.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String mySendMessage(@PathVariable String wcust,HttpServletRequest request,
			HttpSession session, MessageDto messagedto, MemberDto memberDto,
			Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		
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
		
		model.addAttribute("get_myMessage",
				iCustPDSService.getMyMessage(memberDto));
		model.addAttribute("receive_message",
				iCustPDSService.getSendMessage(memberDto));
		model.addAttribute("mblist", iCustPDSService.getPDSList(memberDto));
		model.addAttribute("resource",
				iCustPDSService.getResource_Mine(memberDto));
		model.addAttribute("follow",
				iCustPDSService.getFollow(memberDto.getM_mail()));
		model.addAttribute("recommand",
				iCustPDSService.getRecommand(memberDto.getM_mail()));
		model.addAttribute("r_name",
				iCustPDSService.getMyProfile(memberDto));
		model.addAttribute("get_myscrap",
				iCustPDSService.getMyScrap(memberDto));

		return wcust + "/mySendMessage";
	}

	@RequestMapping(value = "/{wcust}/updatePost.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<?, ?> updatePost(@RequestParam("r_id") int r_id, ModelMap model,
			ResourceDto resourceDto) {

		resourceDto.setR_id(r_id);
		iCustPDSService.updateMyPost(resourceDto);

		return model;
	}

}
