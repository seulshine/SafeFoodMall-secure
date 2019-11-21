package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.BoardService;
import com.ssafy.vo.Board;
import com.ssafy.vo.Comment;

import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController // 화면에는 관심이 없고 데이터 전송에만 관심이 있다!!
@RequestMapping("/api")
@Slf4j // lombok
@CrossOrigin({"*"})
public class BoardRestController {
	
	@Autowired
	BoardService service;
	
	@PostMapping("/insertBoard") 
	@ApiOperation(value="새로운 게시판 글 등록") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> insertBoard(@RequestBody Board board) {
		log.trace("insertBoard: {}", board);
		
		try {
			int result = service.insertBoard(board);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("insertBoard", e);
			throw e; 
		}
		
	}
	
	
	@PutMapping("/updateBoard") 
	@ApiOperation(value="기존 게시판 글 수정") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> updateBoard(@RequestBody Board board) {
		log.trace("updateBoard: {}", board);
		
		try {
			int result = service.updateBoard(board);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("updateBoard", e);
			throw e; 
		}
		
	}
	
	
	
	@GetMapping("/searchBoard/{no}")
	@ApiOperation(value="선택한 게시판을 반환한다") 
	public ResponseEntity<Object> searchBoard(@PathVariable int no) {
		log.trace("searchBoard");
		
		try {
			Board board = service.searchBoard(no);	
			return new ResponseEntity<Object>(board, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("findAllTitles", e);
			throw e; 
		}
	
	}
	
	
	
	@DeleteMapping("/deleteBoard/{id}")
	@ApiOperation(value="선택한 글을 삭제한다.")
	public ResponseEntity<Object> deleteBoard(@PathVariable int no) {
		log.trace("deleteBoard: {}", no);
		
		try {
			int result = service.deleteBoard(no);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("deleteEmployee", e);
			throw e; 
		}
	}
	
	
	
	
	@GetMapping("/searchCommentsByNo/{no}")
	@ApiOperation(value="모든 댓글을 반환한다.", response=List.class) // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> searchCommentsByNo(@PathVariable int no) {
		log.trace("searchCommentsByNo");
		
		try {
			List<Comment> comments = service.searchCommentsByNo(no);
			return new ResponseEntity<Object>(comments, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("searchCommentsByNo", e);
			throw e; 
		}
	
	}
	
	
	
	@GetMapping("/searchAllBoard")
	@ApiOperation(value="모든 게시판 글을 반환한다.", response=List.class) // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> searchAllBoard() {
		log.trace("searchAllBoard");
		
		try {
			List<Board> boards = service.searchAllBoard();
			return new ResponseEntity<Object>(boards, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("searchCommentsByNo", e);
			throw e; 
		}
	
	}
	
	
	@PostMapping("/insertComment") 
	@ApiOperation(value="새로운 댓글 등록") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> insertComment(@RequestBody Comment comment) {
		log.trace("insertComment: {}", comment);
		
		try {
			int result = service.insertComment(comment);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("insertComment", e);
			throw e; 
		}
		
	}
	
	
	@PutMapping("/updateComment") 
	@ApiOperation(value="기존 댓글 수정") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> updateComment(@RequestBody Comment comment) {
		log.trace("updateComment: {}", comment);
		
		try {
			int result = service.updateComment(comment);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("updateComment", e);
			throw e; 
		}
		
	}
	
	
	
	@GetMapping("/searchComment/{id}")
	@ApiOperation(value="회원의 모든 댓글을 반환한다") // 마이페이지 댓글 확인
	public ResponseEntity<Object> searchComment(@PathVariable String id) {
		log.trace("searchComment");
		
		try {
			List<Comment> result = service.searchComment(id);
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("searchComment", e);
			throw e; 
		}
	
	}
	
	
	
	@DeleteMapping("/deleteComment")
	@ApiOperation(value="선택한 댓글을 삭제한다.") 
	public ResponseEntity<Object> deleteComment(@RequestBody Comment comment) {
		log.trace("deleteComment");
		
		try {
			int result = service.deleteComment(comment);
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("deleteComment", e);
			throw e; 
		}
	}
	
	
	
	
}
