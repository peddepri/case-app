package com.example.datacollector.repository;

import com.example.datacollector.model.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataRecord, Long> {
}