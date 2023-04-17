package com.spring.proTest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


@Repository("testDAO")
public class TestDAOImpl {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<TestVO> membersList = null;
		membersList = sqlSession.selectList("mapper.test.selectAllMemberList");
		return membersList;
	}
}
