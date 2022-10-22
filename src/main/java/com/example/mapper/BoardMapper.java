package com.example.mapper;

import java.util.List;

import com.example.controller.form.BoardSaveForm;

public interface BoardMapper {
	
	List<Board> selectBoardList();
	
	Board selectBoard(int boardSeq);
	
	void insertBoard(BoardSaveForm form);
	
	void deleteBoard(int boardSeq);

	void updateBoard(BoardSaveForm form);
	
}
