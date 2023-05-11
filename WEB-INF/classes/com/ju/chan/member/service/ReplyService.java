package com.ju.chan.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ReplyDto;
import com.ju.chan.dto.ResourceDto;
import com.ju.chan.member.dao.ReplyDao;

@Service
public class ReplyService{
	
	@Autowired
	private ReplyDao replyDao;
	
	@Transactional
	public void replyAdd(ReplyDto replyDto) {
		System.out.println("ReplyService replyAdd");
		replyDao.replyAdd(replyDto);
	}

	@Transactional(readOnly=true)
	public List<ReplyDto> getReplyList(int r_id){
		
		return replyDao.replyList(r_id);		
	}

	@Transactional(readOnly=true)
	public List<MemberDto> open_phone(ResourceDto resourceDto) {
		return replyDao.open_phone(resourceDto);
	}

	public void replyDelete(int id) {
		replyDao.replyDelete(id);
	}

}
