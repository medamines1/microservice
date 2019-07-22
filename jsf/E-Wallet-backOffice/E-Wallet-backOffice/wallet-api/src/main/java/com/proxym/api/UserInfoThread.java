/*
 * Created on Feb 3, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.proxym.api;

import javax.servlet.http.HttpSession;

/**
 * Created by med-amine.ben-ahmed on 01/11/2017.
 */
public class UserInfoThread {

	/**
	 * @param userId
	 * @param session
	 */
	public UserInfoThread(String userId, HttpSession session, String ipAddress) {
		super();
		this.userId = userId;
		this.session = session;
		this.ipAddress = ipAddress; 
	}
	/**
	 * @return Returns the session.
	 */
	public HttpSession getSession() {
		return session;
	}
	/**
	 * @param session The session to set.
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}
	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	private String userId;
	private HttpSession session;
	private String ipAddress;
	
}
