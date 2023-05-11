package com.ju.chan.pds.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.ju.chan.dto.*;
import com.ju.chan.pds.dao.*;
@Service
public class CustPDSServiceImple implements ICustPDSService {
	
	@Autowired
	private ICustPDSDao iCustPDSDao;

	@Transactional(readOnly=true)
	public List<ResourceDto> getPDSList(MemberDto dto) {
		return iCustPDSDao.getPDSList(dto);
	}
	
	@Transactional(readOnly=true)
	public ResourceDto getPDS(int pdsid) {
		return iCustPDSDao.getPDS(pdsid);
	}

	public List<ResourceDto> getPdsListTest() {
		return iCustPDSDao.getPDSListTest();
	}

	public List<ResourceDto> search(Map<String, String> maps) {
		return iCustPDSDao.search(maps);
	}
	
	public List<ResourceDto> getResource_Mine(MemberDto memberDto) {
		return iCustPDSDao.getResource_Mine(memberDto);
	}

	public List<ResourceDto> search2(Map<String, String> maps) {
		return iCustPDSDao.search2(maps);
	}
	
	public List<FollowDto> getFollow(String m_mail) {
		return iCustPDSDao.getFollow(m_mail);
	}

	public void setFollow(FollowDto followDto) {
		iCustPDSDao.setFollow(followDto);
	}

	public void setUnFollow(FollowDto followDto) {
		iCustPDSDao.setUnFollow(followDto);
	}

	public List<ResourceDto> getFollowResource(Map<String,String> maps) {
		return iCustPDSDao.getFollowResource(maps);
	}

	public void uploadPDS_movie(ResourceDto pdsdto) {
		iCustPDSDao.uploadPDS_movie(pdsdto);
	}

	public void uploadPDS_picture(ResourceDto pdsdto) {
		iCustPDSDao.uploadPDS_picture(pdsdto);
	}

	public void uploadPDS_text(ResourceDto pdsdto) {
		iCustPDSDao.uploadPDS_text(pdsdto);
	}

	public void uploadPDS_audio(ResourceDto pdsdto) {
		iCustPDSDao.uploadPDS_audio(pdsdto);
	}

	public void deletePost(ResourceDto pdsdto) {
		iCustPDSDao.deletePost(pdsdto);
		
	}

	public List<MemberDto> getRecommand(String str) {
		return iCustPDSDao.getRecommand(str);		
	}

	public String getMyProfile(MemberDto memberDto) {
		return iCustPDSDao.getMyProfile(memberDto);		
	}

	@Override
	public List<CategoryDto> getCategory() {
		return iCustPDSDao.getCategory();
	}

	@Override
	public List<FollowDto> getKeyword_all(MemberDto memberDto) {
		return iCustPDSDao.getKeyword_all(memberDto);
	}

	@Override
	public List<FollowDto> getKeyword(MemberDto memberDto) {
		return iCustPDSDao.getKeyword(memberDto);
	}

	@Override
	public void setKeyword_search(String search_keyword) {
		iCustPDSDao.setKeyword_search(search_keyword);
	}

	@Override
	public List<KeywordDto> keyword_search_check(String search_keyword) {
		return iCustPDSDao.keyword_search_check(search_keyword);
	}

	@Override
	public void setFollow_keyword(FollowDto followDto) {
		iCustPDSDao.setFollow_keyword(followDto);
		
	}

	@Override
	public void setUnFollow2(FollowDto followDto) {
		iCustPDSDao.setUnFollow2(followDto);
		
	}

	@Override
	public void setFollow2(FollowDto followDto) {
		iCustPDSDao.setFollow2(followDto);
		
	}

	@Override
	public void sendMessage(MessageDto messagedto) {
		iCustPDSDao.sendMessage(messagedto);
		
	}

	@Override
	public List<MessageDto> getMyMessage(MemberDto memberDto) {
		return iCustPDSDao.getMyMessage(memberDto);

	}

	@Override
	public List<MessageDto> getSendMessage(MemberDto memberDto) {
		return iCustPDSDao.getSendMessage(memberDto);

	}

	@Override
	public void updateMyPost(ResourceDto resourceDto) {
		iCustPDSDao.updateMyPost(resourceDto);
		
	}

	@Override
	public int getSearchEmail(String search_keyword) {
		System.out.println("1 : "+iCustPDSDao.getSearchEmail(search_keyword));
		return iCustPDSDao.getSearchEmail(search_keyword);
	}

	@Override
	public List<ResourceDto> getFollowResource2(MemberDto memberDto) {
		return iCustPDSDao.getFollowResource2(memberDto);

	}

	@Override
	public List<FollowDto> getMyKeyword(Map<String, String> maps) {
		return iCustPDSDao.getMyKeyword(maps);

	}
	@Override
	public List<ResourceDto> getMyScrap(MemberDto memberDto) {
		return iCustPDSDao.getMyScrap(memberDto);

	}

	@Override
	public void setMyScrap(ScrapDto scrapDto) {
		iCustPDSDao.setMyScrap(scrapDto);
	}

	@Override
	public void sendReport(ReportDto reportDto) {
		iCustPDSDao.sendReport(reportDto);
	}

	@Override
	public ResourceDto getResourceFollow(FollowDto followDto) {
		return iCustPDSDao.getResourceFollow(followDto);
	}

}
