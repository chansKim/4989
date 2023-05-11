package com.ju.chan.pds.dao;

import java.util.List;
import java.util.Map;

import com.ju.chan.dto.*;
public interface ICustPDSDao {
	List<ResourceDto> getPDSList (MemberDto dto);
	ResourceDto getPDS(int pdsid);
	
	List<ResourceDto> getPDSListTest();
	List<ResourceDto> search(Map<String, String> maps);
	List<ResourceDto> getResource_Mine(MemberDto memberDto);
	List<ResourceDto> search2(Map<String, String> maps);
	List<FollowDto> getFollow(String m_mail);
	void setFollow(FollowDto followDto);
	void setUnFollow(FollowDto followDto);
	List<ResourceDto> getFollowResource(Map<String, String> maps);
	void uploadPDS_movie(ResourceDto pdsdto);
	void uploadPDS_picture(ResourceDto pdsdto);
	void uploadPDS_text(ResourceDto pdsdto);
	void uploadPDS_audio(ResourceDto pdsdto);
	void deletePost(ResourceDto pdsdto);
	List<MemberDto> getRecommand(String str);
	String getMyProfile(MemberDto memberDto);
	List<CategoryDto> getCategory();
	List<FollowDto> getKeyword_all(MemberDto memberDto);
	List<FollowDto> getKeyword(MemberDto memberDto);
	void setKeyword_search(String search_keyword);
	List<KeywordDto> keyword_search_check(String search_keyword);
	void setFollow_keyword(FollowDto followDto);
	void setUnFollow2(FollowDto followDto);
	void setFollow2(FollowDto followDto);
	void sendMessage(MessageDto messagedto);
	List<MessageDto> getSendMessage(MemberDto memberDto);
	List<MessageDto> getMyMessage(MemberDto memberDto);
	void updateMyPost(ResourceDto resourceDto);
	int getSearchEmail(String search_keyword);
	List<ResourceDto> getFollowResource2(MemberDto memberDto);
	List<FollowDto> getMyKeyword(Map<String, String> maps);
	List<ResourceDto> getMyScrap(MemberDto memberDto);
	void setMyScrap(ScrapDto scrapDto);
	void sendReport(ReportDto reportDto);
	ResourceDto getResourceFollow(FollowDto followDto);
}
