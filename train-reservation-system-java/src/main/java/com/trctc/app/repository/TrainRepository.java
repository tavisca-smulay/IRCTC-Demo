package com.trctc.app.repository;

import com.trctc.app.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {
    Optional<Train> getTrainByTrainNumber(int trainNumber);

    Integer deleteByTrainNumber(int trainNumber);


}
