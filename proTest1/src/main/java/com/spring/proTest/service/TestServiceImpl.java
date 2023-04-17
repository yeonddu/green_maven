package com.spring.proTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.proTest.dao.TestDAO;

@Service("testService")
@Transactional(propagation = Propagation.REQUIRED)
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDAO testDAO;
	
	@Override
	public List listTests() throws DataAccessException {
		List membersList = null;
		membersList = testDAO.listTests();
		return membersList;
	}