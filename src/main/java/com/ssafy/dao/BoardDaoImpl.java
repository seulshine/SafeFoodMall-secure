package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.Board;
import com.ssafy.vo.Comment;

@Repository
public class BoardDaoImpl implements BoardDao {

	
	private final String ns = "com.ssafy.mapper.BoardMapper.";
	@Autowired
	SqlSession session;
	
	@Override
	public int insertBoard(Board board) {
		System.out.println("boardId  : " + board.getId());
		System.out.println("boardConents : " + board.getContents());
		System.out.println("boardTitle : " + board.getTitle());
		return session.insert(ns+"insertBoard", board);
	}

	@Override
	public int updateBoard(Board board) {
		return session.update(ns+"updateBoard", board);
	}

	@Override
	public Board searchBoard(int no) {
		return session.selectOne(ns+"searchBoard", no);
	}

	@Override
	public int deleteBoard(int no) {
		return session.delete(ns+"deleteBoard", no);
	}

	@Override
	public List<Comment> searchCommentsByNo(int no) {
		return session.selectList(ns+"searchCommentsByNo", no);
	}

	@Override
	public List<Board> searchAllBoard() {
		return session.selectList(ns+"searchAllBoard");
	}



}
