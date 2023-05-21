package com.ssm.bean;

import java.io.Serializable;

public class ShortUserInfo implements Serializable {
	
	private int id;
	
	private String nickName;
	
	private String avatarUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	protected ShortUserInfo(int id, String nickName, String avatarUrl) {
		this.id = id;
		this.nickName = nickName;
		this.avatarUrl = avatarUrl;
	}

	protected ShortUserInfo() {
		
	}
	
	
}
