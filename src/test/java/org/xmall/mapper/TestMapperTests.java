package org.xmall.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import lombok.extern.slf4j.Slf4j;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class TestMapperTests {
	@Autowired
	private TestMapper mapper;

	@Test
	public void getDummyListTest() {
		List<Map<String, Object>> dummyList = mapper.getDummyList();
		//ex1
		//System.out.println(dummyList);
		
		//ex2
		dummyList.stream().forEach(dMap -> log.info(dMap.get("name").toString()));
		
		//ex3
		assertThat(dummyList.size()).isEqualTo(10); //Not error
		//assertThat(dummyList.size()).isEqualTo(11); //error!! expected: 11 but was: 10
		
	}
}
