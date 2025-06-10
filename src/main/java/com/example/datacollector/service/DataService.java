package com.example.datacollector.service;

import com.example.datacollector.model.DataRecord;
import com.example.datacollector.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<DataRecord> getAllDataRecords() {
        return dataRepository.findAll();
    }

    public Optional<DataRecord> getDataRecordById(Long id) {
        return dataRepository.findById(id);
    }

    public DataRecord saveDataRecord(DataRecord dataRecord) {
        return dataRepository.save(dataRecord);
    }

    public void deleteDataRecord(Long id) {
        dataRepository.deleteById(id);
    }

    // Additional methods for fetching data from external APIs can be added here
}