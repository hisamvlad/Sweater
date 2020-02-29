package com.twitterclone.sweater;

import org.springframework.security.crypto.password.PasswordEncoder;

public class DumbPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return String.format("secret: '%s'", rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
