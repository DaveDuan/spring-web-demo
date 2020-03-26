package com.davesmemo.demo.spring.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class ResourceControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void postAResourceTestShouldReturnAResource() throws Exception {
		this.mockMvc
				.perform(post("/resources").contentType("application/json")
						.content("{\"id\":1234567,\"msg\":\"I'm resource 1234567\"}"))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().json("{\"id\":1234567,\"msg\":\"I'm resource 1234567\"}"));
	}

	@Test
	public void getOneResourceShouldReturnAResource() throws Exception {
		this.mockMvc.perform(get("/resources/123456")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":123456,\"msg\":\"I'm resource 123456\"}"));
	}

	@Test
	public void getAllResourceShouldReturnAllResource() throws Exception {
		this.mockMvc.perform(get("/resources")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", is(2)));
	}

	@Test
	public void putAResourceTestShouldReturnAResource() throws Exception {
		this.mockMvc
				.perform(put("/resources/1234567").contentType("application/json")
						.content("{\"id\":1234567,\"msg\":\"I'm resource 1234567\"}"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1234567,\"msg\":\"I'm resource 1234567\"}"));
	}

	@Test
	public void patchAResourceTestShouldReturnAResource() throws Exception {
		this.mockMvc
				.perform(patch("/resources/1234567").contentType("application/json")
						.content("{\"id\":1234567,\"msg\":\"I'm resource 1234567\"}"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1234567,\"msg\":\"I'm resource 1234567\"}"));
	}

	@Test
	public void deleteAResourceTestShouldReturnEmpty() throws Exception {
		this.mockMvc.perform(delete("/resources/1234567")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(""));
	}

}
