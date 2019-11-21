package com.ssafy.dao;

import java.util.List;

import com.ssafy.vo.Board;
import com.ssafy.vo.Comment;

public interface BoardDao {

	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public Board searchBoard(int no);
	public int deleteBoard(int no);
	
	public List<Comment> searchCommentsByNo (int no);
	
}
