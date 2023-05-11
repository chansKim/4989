package com.ju.chan.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ReplyDto;
import com.ju.chan.dto.ResourceDto;

@Repository
public class ReplyDao {

	private String namespace = "member.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void replyAdd(ReplyDto replyDto) {
		// TODO Auto-generated method stub
		getSqlSession().insert(namespace + "addReply", replyDto);
	}

	public List<ReplyDto> replyList(int r_id){
		return getSqlSession().selectList(namespace + "replyList", r_id);
	}

	public List<MemberDto> open_phone(ResourceDto resourceDto) {
		return getSqlSession().selectList(namespace + "open_phone", resourceDto);
	}
	public void replyDelete(int id) {
		// TODO Auto-generated method stub
		getSqlSession().delete(namespace+"deleteReply", id);
	}
	
}
