package com.springboot.TrainingCenters.Services;

import java.util.List;

import com.springboot.TrainingCenters.Entity.TrainingCentersEntity;

public interface TrainingCentersServices {

	TrainingCentersEntity createTrainingCenter(TrainingCentersEntity trainingCenter);

    List<TrainingCentersEntity> getAllTrainingCenters();

    List<TrainingCentersEntity> findByNameContaining(String name);
	
}
 