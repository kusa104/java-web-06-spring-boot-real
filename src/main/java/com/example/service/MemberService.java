package com.example.service;

import org.springframework.stereotype.Service;

import com.example.controller.form.MemberJoinForm;
import com.example.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper memberMapper;

	public int selectMemberAccountCount(String account) {
		return memberMapper.selectMemberAccountCount(account);
	}
	
	public void insertMember(MemberJoinForm form) {
		memberMapper.insertMember(form);
	}
	
}
