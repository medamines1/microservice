package com.proxym.bo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proxym.bo.model.FeatureModel;

public class FeatureMapper {

	 public static FeatureModel featureEntityToFeatureModel(Feature feature) {
	        return new FeatureModel(feature.getCode(), feature.getName(), feature.getPath(), FeatureMapper.listFeatureEntityToListFeatureModel(feature.getChildrenFeatures()), feature.getIcon());
	    }

	    public static Feature featureModelToFeatureEntity(FeatureModel featureModel) {
	    	Feature f = null;
	    	if(featureModel.getParentFeature() != null)
	    		 f = featureModelToFeatureEntity(featureModel.getParentFeature());
	        return new Feature(featureModel.getCode(), featureModel.getName(), featureModel.getPath(), f,featureModel.getIcon());
	    }

	    public static List<FeatureModel> listFeatureEntityToListFeatureModel(List<Feature> features) {
	        return features.stream().map(feature -> featureEntityToFeatureModel(feature)).collect(Collectors.toList());
	    } 

	    public static List<Feature> listFeatureModelToListFeatureEntity(List<FeatureModel> featureModels) {
	        return featureModels.stream().map(featureModel -> featureModelToFeatureEntity(featureModel)).collect(Collectors.toList());
	    }

}
