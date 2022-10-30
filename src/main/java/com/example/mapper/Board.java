package com.example.mapper;

import lombok.Data;

@Data
public class Board {
	
	private int boardSeq;
	private String boardType;
	private String title;
	private String contents;
	private String regDate;
	private String userName; // 회원 이름
	private int memberSeq;
	
}
