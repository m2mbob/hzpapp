package com.example.login;

import android.app.Application;

public class UserInfo extends Application{

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}