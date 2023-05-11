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

import com.ju.chan.dto.FollowDto;
import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ResourceDto;
import com.ju.chan.pds.service.ICustPDSService;


@Controller
public class PdsController {

	@Autowired
	private ICustPDSService iCustPDSService;

	private static final Logger logger = LoggerFactory
			.getLogger(PdsController.class);
	
	@RequestMapping(value = "/{wcust}/pdsupload_movie.do", method = RequestMethod.POST)
	public String pdsupload_movie(
			@PathVariable String wcust,
			ResourceDto pdsdto,MemberDto memberDto,
			HttpServletRequest request,HttpSession session,
			@RequestParam(value = "fileload", required = true) MultipartFile fileload,
			Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		String m_mail = memberDto.getM_mail();
		pdsdto.setM_mail(m_mail);

		pdsdto.setR_name(fileload.getOriginalFilename());
		model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));

		logger.info("Welcome SongController pdsupload! " + new Date());
		logger.info("Welcome SongController pdsdto! " + pdsdto);
		
		String root = session.getServletContext().getRealPath("/");//
		String fupload = root + "upload";
		String f = pdsdto.getR_name();

//		name = new String(name.getBytes("8859_1"),"KSC5601");
		
		String newFile = FUpUtil.getNewFile(f);
		logger.info(fupload + "/" + newFile);
		pdsdto.setR_name(newFile);
		
		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String , String> maps = new HashMap<String, String>();

		try {
			File file = new File(fupload + "/" + newFile);
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			iCustPDSService.uploadPDS_movie(pdsdto);
			model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
			logger.info("Welcome pdsupload success! ");
		} catch (IOException e) {
			logger.info("Welcome pdsupload fail! ");
		}
		
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
		
		return wcust + "/home";
	}//
	
	@RequestMapping(value = "/{wcust}/pdsupload_photo.do", method = RequestMethod.POST)
	public String pdsupload_picture(
			@PathVariable String wcust,
			ResourceDto pdsdto,MemberDto memberDto,
			HttpServletRequest request,HttpSession session,
			@RequestParam(value = "fileload", required = true) MultipartFile fileload,
			Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		String m_mail = memberDto.getM_mail();
		pdsdto.setM_mail(m_mail);

		pdsdto.setR_name(fileload.getOriginalFilename());
		model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));

		logger.info("Welcome SongController pdsupload! " + new Date());
		logger.info("Welcome SongController pdsdto! " + pdsdto);
	
		String root = session.getServletContext().getRealPath("/");//
		String fupload = root + "upload";
		System.out.println("path : " + fupload);
		
		String f = pdsdto.getR_name();

//		name = new String(name.getBytes("8859_1"),"euc-kr");
		
		String newFile = FUpUtil.getNewFile(f);
		logger.info(fupload + "/" + newFile);
		pdsdto.setR_name(newFile);
		
		int post_type = Integer.valueOf(request.getParameter("post_type"));
		int number_type = Integer.valueOf(request.getParameter("number_type"));
		logger.info("post data : " + post_type);
		logger.info("number data : " + number_type);

		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String , String> maps = new HashMap<String, String>();

		try {
			File file = new File(fupload + "/" + newFile);
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			iCustPDSService.uploadPDS_picture(pdsdto);
			model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
			logger.info("Welcome pdsupload success! ");
		} catch (IOException e) {
			logger.info("Welcome pdsupload fail! ");
		}
		

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
		
		
		return wcust + "/home";
	}//
	
	@RequestMapping(value = "/{wcust}/pdsupload_text.do", method = RequestMethod.POST)
	public String pdsupload_text(
			@PathVariable String wcust,
			ResourceDto pdsdto,MemberDto memberDto,
			HttpServletRequest request,Model model,HttpSession session) {
		memberDto = (MemberDto) session.getAttribute("login");
		String m_mail = memberDto.getM_mail();
		
		logger.info("Welcome text upload! " + m_mail);
		pdsdto.setM_mail(m_mail);
				
		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String , String> maps = new HashMap<String, String>();

		iCustPDSService.uploadPDS_text(pdsdto);
		model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
		model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
		model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
		model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
		logger.info("login");
		
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
		
		return wcust + "/home";
	}//
	
	@RequestMapping(value = "/{wcust}/pdsupload_audio.do", method = RequestMethod.POST)
	public String pdsupload_audio(
			@PathVariable String wcust,
			ResourceDto pdsdto,MemberDto memberDto,
			HttpServletRequest request,HttpSession session,
			@RequestParam(value = "fileload", required = false) MultipartFile fileload,
			Model model) {
		memberDto = (MemberDto) session.getAttribute("login");
		String m_mail = memberDto.getM_mail();
		pdsdto.setM_mail(m_mail);

		pdsdto.setR_name(fileload.getOriginalFilename());
		model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));

		logger.info("Welcome SongController pdsupload! " + new Date());
		logger.info("Welcome SongController pdsdto! " + pdsdto);
		
		String root = session.getServletContext().getRealPath("/");//
		String fupload = root + "upload";
		String f = pdsdto.getR_name();

//		name = new String(name.getBytes("8859_1"),"KSC5601");
		
		String newFile = FUpUtil.getNewFile(f);
		logger.info(fupload + "/" + newFile);
		pdsdto.setR_name(newFile);
		
		String p = null;
		p = request.getParameter("param");
		System.out.println("p : " + p);
		Map<String , String> maps = new HashMap<String, String>();

		
		try {
			File file = new File(fupload + "/" + newFile);
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			iCustPDSService.uploadPDS_audio(pdsdto);
			model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
			model.addAttribute("follow",iCustPDSService.getFollow(memberDto.getM_mail()));
			model.addAttribute("recommand",iCustPDSService.getRecommand(memberDto.getM_mail()));
			model.addAttribute("r_name",iCustPDSService.getMyProfile(memberDto));
			logger.info("Welcome pdsupload success! ");
		} catch (IOException e) {
			logger.info("Welcome pdsupload fail! ");
		}
		
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
		
		
		return wcust + "/home";
	}//
	
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search1(@PathVariable String wcust, HttpSession session, 
			HttpServletRequest request,ResourceDto pdsdto, MemberDto memberDto, Model model) {
		String keyword = request.getParameter("searchAll");
		memberDto = (MemberDto) session.getAttribute("login");

		model.addAttribute("resource",iCustPDSService.getResource_Mine(memberDto));
		Map<String , String> maps = new HashMap<String, String>();
		maps.put("keyword", keyword);
		maps.put("m_mail", memberDto.getM_mail());
		
		List<ResourceDto> list = iCustPDSService.search(maps);
		List<ResourceDto> list2 = iCustPDSService.search2(maps);
		
		model.addAttribute("memlist",list);
		model.addAttribute("postlist",list2);
		logger.info("Welcome HomeCtrl search! "+ list);
		logger.info("Welcome HomeCtrl search2! "+ list2);

		return "/search";
	}//
	
	@RequestMapping(value = "/{wcust}/search.do", method = RequestMethod.GET)
	public String search2(@PathVariable String wcust, HttpSession session, 
			HttpServletRequest request,ResourceDto pdsdto, MemberDto memberDto, Model model) {
		String keyword = request.getParameter("searchAll");
		memberDto = (MemberDto) session.getAttribute("login");

		Map<String , String> maps = new HashMap<String, String>();
		maps.put("keyword", keyword);
		maps.put("m_mail", memberDto.getM_mail());

		List<ResourceDto> list = iCustPDSService.search(maps);
		List<ResourceDto> list2 = iCustPDSService.search2(maps);
		List<FollowDto> follow = iCustPDSService.getFollow(memberDto.getM_mail());
		
		model.addAttribute("memlist",list);
		model.addAttribute("postlist",list2);
		model.addAttribute("follow",follow);
		logger.info("Welcome SearchCtrl search! "+ list.toString());
		logger.info("Welcome SearchCtrl search2! "+ list2.toString());
		logger.info("Welcome SearchCtrl follow! "+ follow.toString());
		
		return "/search";
	}
	
	@RequestMapping(value="/{wcust}/follow.do", method={RequestMethod.GET,RequestMethod.POST})
	 public @ResponseBody Map<?,?> follow(@RequestParam("m_mail") String m_mail, 
			 @RequestParam("face_mail") String face_mail, ModelMap model, FollowDto followDto) {
		logger.info("Welcome Follow! "+m_mail + ", " + face_mail+ ", " + face_mail);

		followDto.setM_mail(m_mail);
		followDto.setFace_mail(face_mail);
		
		iCustPDSService.setFollow(followDto);

		return model;
	}
	
	@RequestMapping(value="/{wcust}/unfollow.do", method={RequestMethod.GET,RequestMethod.POST})
	 public @ResponseBody Map<?,?> unfollow(@RequestParam("m_mail") String m_mail, 
			 @RequestParam("face_mail") String face_mail, ModelMap model, FollowDto followDto) {
		logger.info("Welcome Follow! "+m_mail + ", " + face_mail);
		
		followDto.setM_mail(m_mail);
		followDto.setFace_mail(face_mail);
		
		iCustPDSService.setUnFollow(followDto);
		System.out.println("model : " + model);
		return model;
	}
	
	@RequestMapping(value="/{wcust}/follow2.do", method={RequestMethod.GET,RequestMethod.POST})
	 public @ResponseBody Map<?,?> follow2(@RequestParam("m_mail") String m_mail, 
			 @RequestParam("k_name") String k_name, ModelMap model, FollowDto followDto) {
		logger.info("Welcome Follow! "+m_mail + ", " + k_name+ ", " + k_name);

		followDto.setM_mail(m_mail);
		followDto.setK_name(k_name);
		
		iCustPDSService.setFollow2(followDto);

		return model;
	}
	
	@RequestMapping(value="/{wcust}/unfollow2.do", method={RequestMethod.GET,RequestMethod.POST})
	 public @ResponseBody Map<?,?> unfollow2(@RequestParam("m_mail") String m_mail, 
			 @RequestParam("k_name") String k_name, ModelMap model, FollowDto followDto) {
		logger.info("Welcome unFollow! "+m_mail + ", " + k_name);
		
		followDto.setM_mail(m_mail);
		followDto.setK_name(k_name);
		
		iCustPDSService.setUnFollow2(followDto);
		return model;
	}

}
