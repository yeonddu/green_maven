package com.spring.proTest.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface TestService {
	public List listTests() throws DataAccessException;
}
