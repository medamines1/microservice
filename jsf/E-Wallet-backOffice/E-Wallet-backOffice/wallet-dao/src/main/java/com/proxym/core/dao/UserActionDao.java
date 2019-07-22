package com.proxym.core.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserActionDao {
	
	 Page<UserAction> getFiltredUserAction(UserAction userAction, Pageable pageable, Date start,Date end);
	 
	 void saveUserAction(UserAction userAction);

}
