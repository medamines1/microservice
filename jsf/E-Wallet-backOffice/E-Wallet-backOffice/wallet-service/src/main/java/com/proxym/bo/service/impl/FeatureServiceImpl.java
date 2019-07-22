package com.proxym.bo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

//import exceptions.DataNotFoundException;
import com.proxym.bo.mapper.FeatureMapper;
import com.proxym.bo.model.FeatureModel;
import com.proxym.bo.service.FeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.proxym.bo.enumerations.ActionsEnum;
import com.proxym.bo.enumerations.FeaturesEnum;
import com.proxym.core.dao.ActionDao;
import com.proxym.core.dao.FeatureDao;

@Service
public class FeatureServiceImpl implements FeatureService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeatureServiceImpl.class);

	private final FeatureDao featureDao;

	private final ActionDao actionDao;

	@Autowired
	public FeatureServiceImpl(FeatureDao featureDao, ActionDao actionDao) {
		this.featureDao = featureDao;
		this.actionDao = actionDao;
	}

	@Value("${data.sync}")
	private Boolean datasync;

	@PostConstruct
	public void init() {
		if (datasync) {
			Feature feature;
			Optional<Feature> result;
			Feature ffils;
			Feature fffils;
			List<Action> listActions = new ArrayList<>();
			Optional<Action> action = null;
			for (FeaturesEnum f : FeaturesEnum.values()) {
				if (f.getParent() == null && f.getVisible()) {
					feature = new Feature(f.getCode(), f.getName(), f.getPath(), null,f.getIcon());

					result = featureDao.findByCode(feature.getCode());
					if (!result.isPresent())
						feature = featureDao.saveObject(feature);
					else
						feature = result.get();
//								.orElseThrow(() -> new DataNotFoundException("Feature", f.toString(), "Feature"));

					for (ActionsEnum actionEnum : ActionsEnum.values()) {

						if (actionEnum.getFeatureCode().equals(feature.getCode())) {
							action = actionDao.findByActionNameAndControllename(actionEnum.getActionName(),
									actionEnum.getControllerName());
							if (!action.isPresent())
								listActions.add(new Action(actionEnum.getActionName(), actionEnum.getControllerName(),
										feature));
						}
					}
					actionDao.save(listActions);

					for (FeaturesEnum fils : FeaturesEnum.values()) {
						if (fils.getParent() != null && fils.getParent() == f && fils.getVisible()) {
							ffils = new Feature(fils.getCode(), fils.getName(), fils.getPath(), feature,fils.getIcon());
							result = featureDao.findByCode(ffils.getCode());
							if (!result.isPresent())
								ffils = featureDao.saveObject(ffils);
							else
								ffils = result.get();
//								.orElseThrow(
//										() -> new DataNotFoundException("Feature", f.toString(), "Feature"));

							listActions = new ArrayList<>();
							for (ActionsEnum actionEnum : ActionsEnum.values()) {
								if (actionEnum.getFeatureCode().equals(ffils.getCode())) {
									action = actionDao.findByActionNameAndControllename(actionEnum.getActionName(),
											actionEnum.getControllerName());
									if (!action.isPresent())
										listActions.add(new Action(actionEnum.getActionName(),
												actionEnum.getControllerName(), ffils));
								}
							}
							actionDao.save(listActions);
							for (FeaturesEnum fls : FeaturesEnum.values()) {
								if (fls.getParent() != null && fls.getParent() == fils && fls.getVisible()) {
									fffils = new Feature(fls.getCode(), fls.getName(), fls.getPath(), ffils, ffils.getIcon());
									result = featureDao.findByCode(fffils.getCode());
									if (!result.isPresent())
										fffils = featureDao.saveObject(fffils);

									listActions = new ArrayList<>();
									for (ActionsEnum actionEnum : ActionsEnum.values()) {
										if (actionEnum.getFeatureCode().equals(fffils.getCode())) {
											action = actionDao.findByActionNameAndControllename(
													actionEnum.getActionName(), actionEnum.getControllerName());
											if (!action.isPresent())
												listActions.add(new Action(actionEnum.getActionName(),
														actionEnum.getControllerName(), fffils));
										}
									}
									actionDao.save(listActions);
								}
							}
						}
					}
				}
			}
		}

	}

	@Override
	public void save(List<FeatureModel> features) {
		LOGGER.info("[FeatureServiceImpl] save ");
		featureDao.save(FeatureMapper.listFeatureModelToListFeatureEntity(features));
	}

	@Override
	public List<FeatureModel> getFeatures() {
		LOGGER.info("[FeatureServiceImpl] getFeatures ");
		return FeatureMapper.listFeatureEntityToListFeatureModel(featureDao.getFeatures());
	}

	@Override
	public Boolean delete(List<FeatureModel> features) {
		LOGGER.info("[FeatureServiceImpl] delete ");
		return featureDao.delete(FeatureMapper.listFeatureModelToListFeatureEntity(features));
	}

	@Override
	public void update(List<FeatureModel> features) {
		LOGGER.info("[FeatureServiceImpl] update ");
		featureDao.update(FeatureMapper.listFeatureModelToListFeatureEntity(features));
	}

	@Override
	public List<FeatureModel> findByParent(FeatureModel feature) {
		LOGGER.info("[FeatureServiceImpl] findByParent ");
		return FeatureMapper.listFeatureEntityToListFeatureModel(
				featureDao.findByParent(FeatureMapper.featureModelToFeatureEntity(feature)));
	}

	@Override
	public FeatureModel findOneByCode(String code) {
		return FeatureMapper.featureEntityToFeatureModel(featureDao.findOneByCode(code));
	}

	@Override
	public List<FeatureModel> findAllParent() {
		LOGGER.info("[FeatureServiceImpl] findAllParent ");
		return FeatureMapper.listFeatureEntityToListFeatureModel(featureDao.findAllParent());
	}

	@Override
	public void save(FeatureModel feature) {
		LOGGER.info("[FeatureServiceImpl] save ");
		featureDao.save(FeatureMapper.featureModelToFeatureEntity(feature));

	}

}
