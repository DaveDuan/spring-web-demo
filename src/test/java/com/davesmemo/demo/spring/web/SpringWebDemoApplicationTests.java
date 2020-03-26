package com.davesmemo.demo.spring.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.davesmemo.demo.spring.web.controller.ResourceController;

@SpringBootTest
class SpringWebDemoApplicationTests {

	@Autowired
	private ResourceController resourceController;

	@Test
	void contextLoads() {
		assertThat(resourceController).isNotNull();
	}

}
