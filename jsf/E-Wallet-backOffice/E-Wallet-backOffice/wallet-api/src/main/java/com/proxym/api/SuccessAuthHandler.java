package com.proxym.api;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Service;

@Service
public class SuccessAuthHandler implements ApplicationListener<AuthenticationSuccessEvent>{

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent arg0) {
		System.out.println("***********************************************");
		System.out.println("LOGGED IN WITH SUCCESS");
		System.out.println("***********************************************/");



		
	}

}
