package com.proxym.api;


public class BoApplicationAttributes {
	
	private static String contextPath;
	
	private static String iframeUrl;


	public static String getContextPath() {
		return contextPath;
	}

	public static void setContextPath(String contextPath) {
		BoApplicationAttributes.contextPath = contextPath;
	}

	public static String getIframeUrl() {
		return iframeUrl;
	}

	public static void setIframeUrl(String iframeUrl) {
		BoApplicationAttributes.iframeUrl = iframeUrl;
	}
	
	
	
	
	

}
