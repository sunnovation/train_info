package com.boarding.dao;

import com.boarding.entity.TrainInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainInfoRepository extends JpaRepository<TrainInfo,Integer> {
}
