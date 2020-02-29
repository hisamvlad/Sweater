package com.twitterclone.sweater.domain.util;

import com.twitterclone.sweater.domain.User;

public class MessageHelper {
	public static String getAuthorName(User author) {
		return author != null ? author.getUsername() : "<none>";
	}
}
