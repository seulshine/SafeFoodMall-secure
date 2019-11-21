package com.ssafy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	private final String ns = "com.ssafy.mapper.CommentMapper.";
	@Autowired
	SqlSession session;
	
	@Override
	public int insertComment(Comment comment) {
		return session.insert(ns+"insertComment", comment);
	}

	@Override
	public int updateComment(Comment comment) {
		return session.update(ns+"updateComment", comment);
	}

	@Override
	public Comment searchComment(Comment comment) {
		return session.selectOne(ns+"searchComment", comment);
	}

	@Override
	public int deleteComment(Comment comment) {
		return session.delete(ns+"deleteComment", comment);
	}

}
