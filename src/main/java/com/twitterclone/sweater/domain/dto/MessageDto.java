package com.twitterclone.sweater.domain.dto;

import com.twitterclone.sweater.domain.Message;
import com.twitterclone.sweater.domain.User;
import com.twitterclone.sweater.domain.util.MessageHelper;

public class MessageDto {
	    
		private Long id;
	    private String text;
	    private String tag;
	    private User author;
	    private String filename;
	    private Long likes;
	    private Boolean meLiked;
		
	    
	    public MessageDto(Message message, Long likes, Boolean meLiked) {
			super();
			this.id = id;
			this.text = text;
			this.tag = tag;
			this.author = author;
			this.filename = filename;
			this.likes = likes;
			this.meLiked = meLiked;
		}
	    

	    public String getAuthorName() {
	        return MessageHelper.getAuthorName(author);
	    }


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getText() {
			return text;
		}


		public void setText(String text) {
			this.text = text;
		}


		public String getTag() {
			return tag;
		}


		public void setTag(String tag) {
			this.tag = tag;
		}


		public User getAuthor() {
			return author;
		}


		public void setAuthor(User author) {
			this.author = author;
		}


		public String getFilename() {
			return filename;
		}


		public void setFilename(String filename) {
			this.filename = filename;
		}


		public Long getLikes() {
			return likes;
		}


		public void setLikes(Long likes) {
			this.likes = likes;
		}


		public Boolean getMeLiked() {
			return meLiked;
		}


		public void setMeLiked(Boolean meLiked) {
			this.meLiked = meLiked;
		}


		@Override
		public String toString() {
			return "MessageDto [id=" + id + ", author=" + author + ", likes=" + likes + ", meLiked=" + meLiked + "]";
		}
	    
	    
	    
	    
	    
	    
}
