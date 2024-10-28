package com.boarding.dao;

import com.boarding.document.TrainInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainInfoMRepository extends MongoRepository<TrainInfo,Integer> {
}
