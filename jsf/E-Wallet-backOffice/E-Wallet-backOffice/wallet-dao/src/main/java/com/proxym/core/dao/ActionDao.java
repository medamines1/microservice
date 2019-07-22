package com.proxym.core.dao;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Jrebi.Nasreddine
 *
 */
public interface ActionDao {
	

	/**
	 * Used to save Action list
	 * 
	 * @param actions
	 */
	void save(List<Action> actions);
	
	void save(Action action);

	

	/**
	 * Used to retrieve Action list
	 * 
	 * @return
	 */
	List<Action> getActions();


	/**
	 * Used to delete Action list
	 * 
	 * @param actions
	 */
    Boolean delete(List<Action> actions);
    
    
    /**
   	 * Used to Update Action list
   	 * 
   	 * @param actions
   	 */
       void update(List<Action> actions);
       
    /**
	 * Used to retrieve Action list by feature
	 * 
	 * @return
	 */
       List<Action> findByFeature(Feature feature);
       
       Action findOneByName(String name);
       
       Feature findFeatureByActionId(Long id);

       Action findOneByNameAndControllerName(String name,String controller);
       Optional<Action> findByActionNameAndControllename(String aName, String cName);
}
