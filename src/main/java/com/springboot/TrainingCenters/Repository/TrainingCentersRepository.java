package com.springboot.TrainingCenters.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.TrainingCenters.Entity.TrainingCentersEntity;

@Repository
public interface TrainingCentersRepository extends JpaRepository<TrainingCentersEntity, Long> {   
	
}
