package com.springboot.TrainingCenters.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.TrainingCenters.Entity.TrainingCentersEntity;
import com.springboot.TrainingCenters.Repository.TrainingCentersRepository;


@Service
public class TrainingCentersServicesImpl implements TrainingCentersServices {

	@Autowired
    private TrainingCentersRepository trainingCenterRepository;

	
	@Override
	public TrainingCentersEntity createTrainingCenter(TrainingCentersEntity trainingCenter) {
		
		return trainingCenterRepository.save(trainingCenter);
		   
	}

	@Override
	public List<TrainingCentersEntity> getAllTrainingCenters() {
		
		return (List<TrainingCentersEntity>) trainingCenterRepository.findAll();
	    
	}

	
	List<TrainingCentersEntity> centerDetails = new ArrayList<TrainingCentersEntity>();
	
	@Override
	public List<TrainingCentersEntity> findByNameContaining(String name) {
		
		List<TrainingCentersEntity> trainingCentersEntity = trainingCenterRepository.findAll();
		
		int i=0;
		while(i<trainingCentersEntity.size()) {
			
			TrainingCentersEntity centersEntity = trainingCentersEntity.get(i);

			if(name.equalsIgnoreCase(centersEntity.getCenterName())) {
			
				TrainingCentersEntity centerDetail = new TrainingCentersEntity();
				
				centerDetail.setId(centersEntity.getId());
				centerDetail.setCenterName(centersEntity.getCenterName());
				centerDetail.setCenterCode(centersEntity.getCenterCode());
				centerDetail.setAddress(centersEntity.getAddress());
				centerDetail.setStudentCapacity(centersEntity.getStudentCapacity());
				centerDetail.setCoursesOffered(centersEntity.getCoursesOffered());
				centerDetail.setCreatedOn(centersEntity.getCreatedOn());
				centerDetail.setContactEmail(centersEntity.getContactEmail());
				centerDetail.setContactPhone(centersEntity.getContactPhone());
				
				centerDetails.add(centerDetail);
				
				return centerDetails;
				
			}
			
			i++;
			
		}
		
		return null;  
		
	}

}