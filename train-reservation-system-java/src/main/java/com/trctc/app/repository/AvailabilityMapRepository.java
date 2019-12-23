package com.trctc.app.repository;

import com.trctc.app.model.AvailabilityMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityMapRepository extends JpaRepository<AvailabilityMap,Long> {

    List<AvailabilityMap> findByDate(String date);
    List<AvailabilityMap> findByTrainIdAndDate(int trainId, String date);

}
