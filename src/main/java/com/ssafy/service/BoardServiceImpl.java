package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.BoardDao;
import com.ssafy.dao.CommentDao;
import com.ssafy.vo.Board;
import com.ssafy.vo.Comment;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao bdao;
	
	@Autowired
	CommentDao cdao;
	
	@Override
	public int insertBoard(Board board) {
		return bdao.insertBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
		return bdao.updateBoard(board);
	}

	@Override
	public Board searchBoard(int no) {
		return bdao.searchBoard(no);
	}

	@Override
	public int deleteBoard(int no) {
		return bdao.deleteBoard(no);
	}

	@Override
	public List<Comment> searchCommentsByNo(int no) {
		return bdao.searchCommentsByNo(no);
	}
	
	@Override
	public List<Board> searchAllBoard() {
		return bdao.searchAllBoard();
	}
	
	

	@Override
	public int insertComment(Comment comment) {
		return cdao.insertComment(comment);
	}

	@Override
	public int updateComment(Comment comment) {
		return cdao.updateComment(comment);
	}

	@Override
	public List<Comment> searchComment(String id){
		return cdao.searchComment(id);
	}

	@Override
	public int deleteComment(Comment comment) {
		return cdao.deleteComment(comment);
	}


}
