package org.xmall.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmall.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	private TestMapper mapper;
	
	public List<Map<String, Object>> getDummyList(){
		return mapper.getDummyList();
	}

	public List<Map<String, Object>> getDummyListWithCount(int count) {
		return mapper.getDummyListWithCount(count);
	}
}
