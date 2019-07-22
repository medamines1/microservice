package com.proxym.bo.service.impl;

import java.util.List;

import com.proxym.bo.model.ActionModel;
import com.proxym.bo.model.FeatureModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxym.bo.mapper.ActionMapper;
import com.proxym.bo.mapper.FeatureMapper;
import com.proxym.bo.service.ActionService;
import com.proxym.core.dao.ActionDao;

@Service
public class ActionServiceImpl implements ActionService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ActionServiceImpl.class);

	private final ActionDao actionDao;

    @Autowired
    public ActionServiceImpl(ActionDao actionDao) {
        this.actionDao = actionDao;
    }
    
	@Override
	public void save(List<ActionModel> actions) {
		LOGGER.info("[ActionServiceImpl] save ");
		List<Action> list = ActionMapper.listActionModelToListActioneEntity(actions);
		actionDao.save(list);
	}

	@Override
	public List<ActionModel> getActions() {       	
		LOGGER.info("[ActionServiceImpl] getActions ");
		return ActionMapper.listActionEntityToListActionModel(actionDao.getActions());
	}

	@Override
	public Boolean delete(List<ActionModel> actions) {       	
		LOGGER.info("[ActionServiceImpl] delete ");
		return actionDao.delete(ActionMapper.listActionModelToListActioneEntity(actions));
	}

	@Override
	public void update(List<ActionModel> actions) {       	
		LOGGER.info("[ActionServiceImpl] update ");
		actionDao.update(ActionMapper.listActionModelToListActioneEntity(actions));
	}

	@Override
	public List<ActionModel> findByFeature(FeatureModel feature) {
		LOGGER.info("[ActionServiceImpl] findByFeature ");
		return ActionMapper.listActionEntityToListActionModel(actionDao.findByFeature(FeatureMapper.featureModelToFeatureEntity(feature)));
	}

	@Override
	public ActionModel findOneByName(String name) {       	
		LOGGER.info("[ActionServiceImpl] findOneByName ");
		return ActionMapper.actionEntityToActionModel(actionDao.findOneByName(name));
	}

	@Override
	public FeatureModel findFeatureByActionId(Long id) {       	
		LOGGER.info("[ActionServiceImpl] findFeatureByActionId ");
		return FeatureMapper.featureEntityToFeatureModel(actionDao.findFeatureByActionId(id));
	}

	@Override
	public ActionModel findOneByNameAndControllerName(String name, String controller) {       	
		LOGGER.info("[ActionServiceImpl] findOneByNameAndControllerName ");
		return ActionMapper.actionEntityToActionModel(actionDao.findOneByNameAndControllerName(name, controller));
	}

	@Override
	public void save(ActionModel action) {       	
		LOGGER.info("[ActionServiceImpl] save ");
		actionDao.save(ActionMapper.actionModelToActionEntity(action));		
	}

}
