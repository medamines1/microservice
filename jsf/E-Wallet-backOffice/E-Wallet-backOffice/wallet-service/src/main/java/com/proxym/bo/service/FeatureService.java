package com.proxym.bo.service;

import java.util.List;

import com.proxym.bo.model.FeatureModel;

public interface FeatureService {

	
	void save(List<FeatureModel> features);
	
	void save(FeatureModel feature);

	
	List<FeatureModel> getFeatures();

    Boolean delete(List<FeatureModel> features);
    
   
    void update(List<FeatureModel> features);
    
	List<FeatureModel> findByParent(FeatureModel feature);
	
	FeatureModel findOneByCode(String code);

	List<FeatureModel> findAllParent();

	
}
