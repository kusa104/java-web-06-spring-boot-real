package com.example.mapper;

import com.example.domain.Member;

public interface MemberMapper {

	int selectMemberAccountCount(String account);
	
	void insertMember(Member member);

	Member selectMemberAccount(String username);
	
}
