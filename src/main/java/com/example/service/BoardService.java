package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.Board;
import com.example.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	/**
	 * 게시물 목록 조회 후 리턴
	 * @return
	 */
	public List<Board> selectBoardList() {
		return boardMapper.selectBoardList();
	}

}
