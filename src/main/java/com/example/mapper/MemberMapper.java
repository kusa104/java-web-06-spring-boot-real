package com.example.mapper;

import com.example.controller.form.MemberJoinForm;

public interface MemberMapper {

	int selectMemberAccountCount(String account);
	
	void insertMember(MemberJoinForm form);
	
}
