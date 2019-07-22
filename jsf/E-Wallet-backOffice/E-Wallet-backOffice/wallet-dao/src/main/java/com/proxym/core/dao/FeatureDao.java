package com.proxym.core.dao;

import java.util.List;
import java.util.Optional;


/**
 * 
 * @author Jrebi.Nasreddine
 *
 */
public interface FeatureDao {



	/**
	 * Used to save Feature list
	 * 
	 * @param features
	 */
	void save(List<Feature> features);

	void save(Feature feature);
	Feature saveObject(Feature feature);
	

	/**
	 * Used to retrieve Feature list
	 * 
	 * @return
	 */
	List<Feature> getFeatures();


	/**
	 * Used to delete Feature list
	 * 
	 * @param features
	 */
    Boolean delete(List<Feature> features);
    
    /**
	 * Used to Update Feature list
	 * 
	 * @param features
	 */
    void update(List<Feature> features);
    
    
	/**
	 * Used to retrieve Feature list by parent
	 * 
	 * @return
	 */
	List<Feature> findByParent(Feature feature);
	
	/**
	 * Used to retrieve Feature  by code
	 * 
	 * @return
	 */
	Feature findOneByCode(String code);
	
	List<Feature> findAllParent();

	Optional<Feature> findByCode(String code);
	
}

