package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Board;
import com.ssafy.vo.Comment;

public interface BoardService {
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public Board searchBoard(int no);
	public int deleteBoard(int no);
	
	public List<Comment> searchCommentsByNo (int no);
	
	public int insertComment(Comment comment);
	public int updateComment(Comment comment);
	public Comment searchComment(Comment comment);
	public int deleteComment(Comment comment);
}
