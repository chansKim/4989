package com.ju.chan.pds.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.*;
import org.springframework.transaction.support.*;

import com.ju.chan.dto.*;

@Repository
public class CustPDSDaoImple implements ICustPDSDao {

	private String namespace = "CustPDSMap.";
	private static final Logger logger = LoggerFactory
			.getLogger(CustPDSDaoImple.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private DataSourceTransactionManager tManager;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public List<ResourceDto> getPDSList(MemberDto dto) {
		System.out.println(dto.getM_mail());
		return getSqlSession().selectList(namespace + "getPDSList", dto);
	}

	public ResourceDto getPDS(int pdsid) {
		return null;
	}

	public List<ResourceDto> getPDSListTest() {
		return getSqlSession().selectList(namespace + "getPDSListTest");
	}

	public List<ResourceDto> search(Map<String, String> maps) {
		logger.debug(" getSearch ------------------>");

		List<ResourceDto> list = getSqlSession().selectList(
				namespace + "getSearch", maps);
		System.out.println("list : " + list.size());

		return list;
	}

	public List<ResourceDto> getResource_Mine(MemberDto mdto) {
		List<ResourceDto> list = getSqlSession().selectList(
				namespace + "getResource_mine", mdto);
		System.out.println("list : " + list.size());

		return list;
	}

	public List<ResourceDto> search2(Map<String, String> maps) {
		logger.debug(" getSearch ------------------>");

		List<ResourceDto> list = getSqlSession().selectList(
				namespace + "getSearch2", maps);
		System.out.println("list : " + list.size());

		return list;
	}

	public List<FollowDto> getFollow(String m_mail) {
		List<FollowDto> list = getSqlSession().selectList(
				namespace + "getFollow", m_mail);
		System.out.println("follow : " + list.size());

		return list;
	}

	public void setFollow(FollowDto followDto) {
		getSqlSession().insert(namespace + "setFollow", followDto);
	}

	public void setUnFollow(FollowDto followDto) {
		getSqlSession().insert(namespace + "setUnFollow", followDto);
	}

	public List<ResourceDto> getFollowResource(Map<String,String> maps) {
		List<ResourceDto> list = getSqlSession().selectList(
				namespace + "getFollowResource", maps);
		System.out.println("followResource list : " + list.size());

		return list;
	}

	public void uploadPDS_movie(ResourceDto pdsdto) {
		getSqlSession().insert(namespace + "uploadPDS_movie", pdsdto);

	}

	public void uploadPDS_picture(ResourceDto pdsdto) {
		getSqlSession().insert(namespace + "uploadPDS_picture", pdsdto);

	}

	public void uploadPDS_text(ResourceDto pdsdto) {
		getSqlSession().insert(namespace + "uploadPDS_text", pdsdto);

	}

	public void uploadPDS_audio(ResourceDto pdsdto) {
		getSqlSession().insert(namespace + "uploadPDS_audio", pdsdto);

	}

	public void deletePost(ResourceDto pdsdto) {
		getSqlSession().insert(namespace + "deletePost", pdsdto);
	}

	public List<MemberDto> getRecommand(String str) {
		List<MemberDto> list = getSqlSession().selectList(
				namespace + "getRecommandMember", str);
		return list;

	}

	public String getMyProfile(MemberDto memberDto) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = tManager.getTransaction(def);
		String str = null;
		try {
			getSqlSession().insert(namespace + "deleteProfile", memberDto);
			str = getSqlSession().selectOne(namespace + "getMyProfile",
					memberDto);
		} catch (Exception e) {
			tManager.rollback(status);
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		tManager.commit(status);

		return str;
	}

	@Override
	public List<CategoryDto> getCategory() {
		List<CategoryDto> list = getSqlSession().selectList(
				namespace + "getCategory");
		System.out.println("category : " + list.size());

		return list;
	}

	@Override
	public List<FollowDto> getKeyword_all(MemberDto memberDto) {
		List<FollowDto> list = getSqlSession().selectList(
				namespace + "getKeyword_all", memberDto);
		System.out.println("keyword_all : " + list.size());

		return list;
	}

	@Override
	public List<FollowDto> getKeyword(MemberDto memberDto) {
		List<FollowDto> list = getSqlSession().selectList(
				namespace + "getKeyword", memberDto);
		System.out.println("My Keyword : " + list.size());

		return list;
	}

	@Override
	public void setKeyword_search(String search_keyword) {
		getSqlSession().insert(namespace + "search_keyword", search_keyword);
	}

	@Override
	public List<KeywordDto> keyword_search_check(String search_keyword) {
		List<KeywordDto> list = getSqlSession().selectList(
				namespace + "keyword_search_check", search_keyword);
		System.out.println("keyword : " + list.size());

		return list;
	}

	@Override
	public void setFollow_keyword(FollowDto followDto) {
		getSqlSession().insert(namespace + "setFollow_keyword", followDto);

	}

	@Override
	public void setUnFollow2(FollowDto followDto) {
		getSqlSession().insert(namespace + "setUnFollow2", followDto);

	}

	@Override
	public void setFollow2(FollowDto followDto) {
		getSqlSession().insert(namespace + "setFollow2", followDto);

	}

	@Override
	public void sendMessage(MessageDto messagedto) {
		getSqlSession().insert(namespace + "send_message", messagedto);

	}

	@Override
	public List<MessageDto> getMyMessage(MemberDto memberDto) {
		List<MessageDto> list = getSqlSession().selectList(
				namespace + "get_myMessage", memberDto);

		return list;
	}

	@Override
	public List<MessageDto> getSendMessage(MemberDto memberDto) {
		List<MessageDto> list = getSqlSession().selectList(
				namespace + "get_sendMessage", memberDto);

		return list;
	}

	@Override
	public void updateMyPost(ResourceDto resourceDto) {
		getSqlSession().update(namespace + "updateMyPost", resourceDto);
	}

	@Override
	public int getSearchEmail(String search_keyword) {
		return (int)getSqlSession().selectOne(namespace + "searchMEmail", search_keyword);
	}

	@Override
	public List<ResourceDto> getFollowResource2(MemberDto memberDto) {
		List<ResourceDto> list = getSqlSession().selectList(
				namespace + "getFollowResource2", memberDto);

		return list;
	}

	@Override
	public List<FollowDto> getMyKeyword(Map<String, String> maps) {
		List<FollowDto> list = getSqlSession().selectList(
				namespace + "getMyKeyword", maps);

		return list;
	}


	@Override
	public List<ResourceDto> getMyScrap(MemberDto memberDto) {
		List<ResourceDto> list = getSqlSession().selectList(
				namespace + "get_myScrap", memberDto);

		return list;
	}

	@Override
	public void setMyScrap(ScrapDto scrapDto) {
		getSqlSession().insert(namespace + "set_myScrap", scrapDto);

	}

	@Override
	public void sendReport(ReportDto reportDto) {
		getSqlSession().insert(namespace + "send_report", reportDto);
	}

	@Override
	public ResourceDto getResourceFollow(FollowDto followDto) {
		ResourceDto rDto = getSqlSession().selectOne(
				namespace + "getResourceFollow", followDto);
		return rDto;
	}
}
