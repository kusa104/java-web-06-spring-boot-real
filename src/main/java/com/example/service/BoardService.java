package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.controller.form.BoardSaveForm;
import com.example.mapper.Board;
import com.example.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardMapper boardMapper;
	
	/**
	 * 게시물 목록 조회 후 리턴
	 * @return
	 */
	public List<Board> selectBoardList() {
		return boardMapper.selectBoardList();
	}
	
	public Board selectBoard(int boardSeq) {
		return boardMapper.selectBoard(boardSeq);
	}
	
	public void insertBoard(BoardSaveForm form) {
		boardMapper.insertBoard(form);
	}
	
	public void updateBoard(BoardSaveForm form) {
		boardMapper.updateBoard(form);
	}
	
	public void deleteBoard(int boardSeq) {
		boardMapper.deleteBoard(boardSeq);
	}

}
