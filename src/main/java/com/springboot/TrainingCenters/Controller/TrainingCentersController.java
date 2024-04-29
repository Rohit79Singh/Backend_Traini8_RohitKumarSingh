package com.springboot.TrainingCenters.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.TrainingCenters.Entity.TrainingCentersEntity;
import com.springboot.TrainingCenters.Services.TrainingCentersServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")
@Api(tags = "TrainingCenters", description = "Operations for Training Centers")
public class TrainingCentersController {

	    @Autowired
	    private TrainingCentersServices trainingCenterService;

	    @PostMapping
	    @ApiOperation("Add new training centers")
	    public ResponseEntity<TrainingCentersEntity> createTrainingCenter(@RequestBody @Valid TrainingCentersEntity trainingCenter) {
	        trainingCenter.setCreatedOn(System.currentTimeMillis());
	        TrainingCentersEntity created = trainingCenterService.createTrainingCenter(trainingCenter);
	        return ResponseEntity.ok(created);
	    }

	    @GetMapping
	    @ApiOperation("Get all training centers")
	    public ResponseEntity<List<TrainingCentersEntity>> getAllTrainingCenters(@RequestParam(value = "name", required = false) String name) {
	        List<TrainingCentersEntity> trainingCenters;
	        if (name != null) {
	            trainingCenters = trainingCenterService.findByNameContaining(name);
	        } else {
	            trainingCenters = trainingCenterService.getAllTrainingCenters();
	        }
	        return ResponseEntity.ok(trainingCenters);
	    }

	
}