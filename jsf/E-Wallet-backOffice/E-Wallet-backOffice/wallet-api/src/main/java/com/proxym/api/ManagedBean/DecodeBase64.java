package com.proxym.api.ManagedBean;

import javax.annotation.ManagedBean;

import org.apache.commons.codec.binary.Base64;

@ManagedBean
public class DecodeBase64 {
	
	public static String decode(String string){
		byte[] byteArray = Base64.decodeBase64(string.getBytes());
		  String decodedString = new String(byteArray);
		  return decodedString;

	}

}
