package com.twitterclone.sweater;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import org.junit.Assert;

class DumbPasswordEncoderTest {

	@Test
	void encode() {
		DumbPasswordEncoder encoder = new DumbPasswordEncoder();
		
		Assert.assertEquals("secret: 'mypwd'", encoder.encode("mypwd"));
		Assert.assertThat(encoder.encode("mypwd"), Matchers.containsString("mypwd"));
	}

}
