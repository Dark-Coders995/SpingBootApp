package com.example.demo.service;

import com.example.demo.dto.AddressRequest;
import com.example.demo.dto.TrainingCenterRequest;
import com.example.demo.model.Address;
import com.example.demo.model.TrainingCenter;
import com.example.demo.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {
    private final TrainingCenterRepository repository;

    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public TrainingCenter createTrainingCenter(TrainingCenterRequest request) {
        System.out.println("Creating training center: " + request);
        TrainingCenter center = new TrainingCenter();
        center.setCenterName(request.getCenterName());
        center.setCenterCode(request.getCenterCode());
        center.setAddress(convertAddress(request.getAddress()));
        center.setStudentCapacity(request.getStudentCapacity());
        center.setCoursesOffered(request.getCoursesOffered());
        center.setContactEmail(request.getContactEmail());
        center.setContactPhone(request.getContactPhone());
        center.setCreatedOn(System.currentTimeMillis());
        return repository.save(center);
    }

    private Address convertAddress(AddressRequest request) {
        Address address = new Address();
        address.setDetailedAddress(request.getDetailedAddress());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setPinCode(request.getPinCode());
        return address;
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }
}