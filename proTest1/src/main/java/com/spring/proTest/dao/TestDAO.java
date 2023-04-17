package com.spring.proTest.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface TestDAO {
	public List selectAllMemberList() throws DataAccessException;
}
