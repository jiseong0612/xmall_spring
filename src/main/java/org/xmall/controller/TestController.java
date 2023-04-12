package org.xmall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmall.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/api")
public class TestController {
	@Autowired
	private TestService service;

	@GetMapping("/")
	public String home(Model model) {
		log.info("home .......");

		String data = "Home Controller!!";

		model.addAttribute("data", data);

		return "/test/home";
	}

	@GetMapping("/getDummy")
	@ResponseBody
	public List<Map<String, Object>> getDummy(Model model) {
		log.info("get Dummy.......");

		List<Map<String, Object>> dummyList = service.getDummyList();
		model.addAttribute("dummyList", dummyList);

		dummyList.stream().forEach(dMap -> log.info(dMap.get("name").toString()));
		return dummyList;
		//return "/test/dummyList";
	}

	@PostMapping("/postDummy")
	@ResponseBody
	public List<Map<String, Object>> postDummy() {
		log.info("post Dummy.......");

		List<Map<String, Object>> dummyList = service.getDummyList();

		dummyList.stream().forEach(dMap -> log.info(dMap.get("name").toString()));

		return dummyList;
	}
	
	/**
	 * RESTful url 매핑 test 
	 * @param count 최대 10개 조회가능 (DB 데이터 10개 확인됨)
	 */
	@PostMapping("/postDummyCount/{count}")
	@ResponseBody
	public List<Map<String, Object>> postDummyCount(@PathVariable int count) {
		log.info("post Dummy count >>>>> " + count);

		List<Map<String, Object>> dummyList = service.getDummyListWithCount(count);

		dummyList.stream().forEach(dMap -> log.info(dMap.get("name").toString()));

		return dummyList;

	}
}
