package com.boarding.controller;

import com.boarding.service.BoardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TrainInfoSceduleer {

    @Autowired
    private BoardingService boardingService;

    @Scheduled(cron = "0/5 * * ? * *")
    public void processDataOfBoardingStation(){
        boardingService.processData();
    }

    @Scheduled(cron = "0/10 * * ? * *")
    public void notificationOfBoarding(){

        boardingService.notificationOfBoarding();
    }


}
