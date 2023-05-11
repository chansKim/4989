package com.ju.chan.member.service;

import com.ju.chan.dto.FollowDto;
import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ResourceDto;


public interface IMemberService {

	boolean memberAdd(MemberDto memberDto, FollowDto followDto);
	MemberDto login(MemberDto dto);
	void uploadMainPic(ResourceDto resDto);
	void withdrawal(MemberDto memberDto);

}
