package com.ju.chan.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ju.chan.dto.FollowDto;
import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ResourceDto;
import com.ju.chan.member.dao.IMemberDao;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	private IMemberDao memberDao;
	
	@Transactional
	public boolean memberAdd(MemberDto memberDto, FollowDto followDto) {
		return memberDao.memberAdd(memberDto, followDto);
	}

	@Transactional(readOnly=true)
	public MemberDto login(MemberDto dto) {
		return memberDao.login(dto);
	}

	public void uploadMainPic(ResourceDto resDto) {
		memberDao.uploadMainPic(resDto);
	}

	@Override
	public void withdrawal(MemberDto memberDto) {
		memberDao.withdrawal(memberDto);		
	}
}
