package com.ju.chan.member.dao;

import com.ju.chan.dto.FollowDto;
import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ResourceDto;

public interface IMemberDao {
    boolean memberAdd(MemberDto memberDto, FollowDto followDto);
	MemberDto login(MemberDto dto);
	void uploadMainPic(ResourceDto resDto);
	void withdrawal(MemberDto memberDto);
	
}
