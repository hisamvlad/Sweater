package com.twitterclone.sweater;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.twitterclone.sweater.controller.MessageController;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class LoginTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private MessageController controller;
	
	@Test
	public void contextLoad() throws Exception {
		this.mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello, guest")))
		.andExpect(content().string(containsString("Please, login")));
	}
	
	@Test
	public void accessDeniedTest() throws Exception {
		this.mockMvc.perform(get("/main"))
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("http://localhost/login"));
	}
	
	@Test
	public void correctLoginTest() throws Exception {
		// insert name of the real user here
		this.mockMvc.perform(formLogin().user("user").password("password"))
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/"));
	}
	
	@Test
	public void badCredentials() throws Exception {
		this.mockMvc.perform(post("/login").param("user", "Albert"))
		.andDo(print())
		.andExpect(status().isForbidden());
	}
}
