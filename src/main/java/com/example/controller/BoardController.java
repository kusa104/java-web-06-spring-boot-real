package com.example.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.controller.form.BoardSaveForm;
import com.example.mapper.Board;
import com.example.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	private final BoardService boardService;
	
	/**
	 * 게시물 목록 조회 및 화면
	 * @param model
	 * @return
	 */
	@GetMapping
	public String list(Model model) {
		// 게시물 목록 조회 후 model에 boardList key로 저장
		model.addAttribute("boardList", boardService.selectBoardList());
		// jsp를 호출
		return "/board/list";
	}
	
	/**
	 * 게시물 상세 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/{boardSeq}")
	public String form(Model model, @PathVariable int boardSeq) {
		// 게시물 조회
		Board board = boardService.selectBoard(boardSeq);
		// board가 null일 경우 에러 메세지 출력
		Assert.notNull(board, "게시글 정보가 없습니다.");
		// detail.html에서 board를 사용하기 위해 model에 넣는다.
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	/**
	 * 게시물 등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public String form(Model model) {
		return "/board/form";
	}
	
	/**
	 * 게시물 등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/form-body")
	public String formBody(Model model) {
		return "/board/form-body";
	}
	
	/**
	 * 게시물 수정 화면
	 * @param model
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/edit/{boardSeq}")
	public String edit(Model model, @PathVariable int boardSeq) {
		// 데이터 조회
		Board board = boardService.selectBoard(boardSeq);
		// board가 null일 경우 에러 메세지 출력
		Assert.notNull(board, "게시글 정보가 없습니다.");
		model.addAttribute("board", board);
		return "/board/form";
	}
	
	/**
	 * 게시물 등록/저장 요철 처리
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String save(@Validated BoardSaveForm form) {
		Board selectBoard = null;
		// 게시글 수정으로 요청인경우
		if (form.getBoardSeq() > 0) {
			selectBoard = boardService.selectBoard(form.getBoardSeq());
		}
		// 수정인 경우 업데이트
		if (selectBoard != null) {
			boardService.updateBoard(form);
		} else {
			boardService.insertBoard(form);
		}
		// 게시물 목록 화면으로 URL 리다렉트
		return "redirect:/board";
	}
	
	@PostMapping("/save-body")
	@ResponseBody
	public HttpEntity<Boolean> saveBody(@Validated @RequestBody BoardSaveForm board) {
		Board selectBoard = null;
		// 게시글 수정으로 요청인경우
		if (board.getBoardSeq() > 0) {
			selectBoard = boardService.selectBoard(board.getBoardSeq());
		}
		// 수정인 경우 업데이트
		if (selectBoard != null) {
			boardService.updateBoard(board);
		} else {
			boardService.insertBoard(board);
		}
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public HttpEntity<Boolean> delete(@RequestParam int boardSeq) {
		// 데이터 조회
		Board board = boardService.selectBoard(boardSeq);
		// board가 null일 경우 에러 메세지 출력
		Assert.notNull(board, "게시글 정보가 없습니다.");
		boardService.deleteBoard(boardSeq);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
	
}
