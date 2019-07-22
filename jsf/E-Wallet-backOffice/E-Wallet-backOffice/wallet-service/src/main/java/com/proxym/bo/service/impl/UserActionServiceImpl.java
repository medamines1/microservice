package com.proxym.bo.service.impl;

import java.util.Date;

import com.proxym.bo.mapper.UserActionMapper;
import com.proxym.bo.model.UserActionModel;
import com.proxym.bo.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.proxym.core.dao.UserActionDao;

@Service
public class UserActionServiceImpl implements UserActionService {
	
	@Autowired
	private UserActionDao userActionDao;
	

	@Override
	public Page<UserActionModel> getFiltredUserAction(UserActionModel userAction, Pageable pageable, Date start,
                                                      Date end) {
		Page<UserAction> page =  userActionDao.getFiltredUserAction(UserActionMapper.mapToUserAction(userAction), pageable, start, end);
		
		Page<UserActionModel> result = page.map(new Converter<UserAction, UserActionModel>(){
			public UserActionModel convert(UserAction source) {
				return UserActionMapper.mapToUserActionModel(source);
			};
		});
		return result;
	}

	@Override
	@Async
	public void saveUserAction(UserActionModel userAction) {
		userActionDao.saveUserAction(UserActionMapper.mapToUserAction(userAction));
	}
}
