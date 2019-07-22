package com.proxym.bo.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proxym.bo.model.UserActionModel;

public interface UserActionService {

	Page<UserActionModel> getFiltredUserAction(UserActionModel userAction, Pageable pageable, Date start,Date end);
	 
	 void saveUserAction(UserActionModel userAction);
}
