package com.ssafy.dao;

import java.util.List;

import com.ssafy.vo.Comment;

public interface CommentDao {

	public int insertComment(Comment comment);
	public int updateComment(Comment comment);
	public List<Comment> searchComment(String id);
	public int deleteComment(Comment comment);
	

}
