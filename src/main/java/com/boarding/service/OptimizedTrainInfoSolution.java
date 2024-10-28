package com.boarding.service;


import com.boarding.dao.TrainInfoMRepository;
import com.boarding.entity.TrainInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class OptimizedTrainInfoSolution {
    private static final Logger log = LoggerFactory.getLogger(OptimizedTrainInfoSolution.class);

    ExecutorService executorService;
    @Autowired
    private TrainInfoMRepository trainInfoMRepository;
    public void processDataintoOptimized(List<TrainInfo> trainInfos){

        try{
            trainInfoMRepository.deleteAll();
            executorService= Executors.newFixedThreadPool(10);

            List<TrainInfo> batch1=trainInfos.subList(0, 10);
            List<TrainInfo> batch2=trainInfos.subList(11, 20);
            List<TrainInfo> batch3=trainInfos.subList(21, 30);
            List<TrainInfo> batch4=trainInfos.subList(31, 40);
            List<TrainInfo> batch5=trainInfos.subList(41, 50);
            List<TrainInfo> batch6=trainInfos.subList(51, trainInfos.size());



            Future<Boolean> task1 = executorService.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {

                    log.info("starting expensive task thread %s",
                            Thread.currentThread().getName());
                    Boolean returnedValue = processIntoMongoDBBatch1(batch1);

                    return returnedValue;
                }
          });
            Future<Boolean> task2 = executorService.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {

                    log.info("starting expensive task thread ",
                            Thread.currentThread().getName());
                    Boolean returnedValue = processIntoMongoDBBatch1(batch2);

                    return returnedValue;
                }
            });
            Future<Boolean> task3 = executorService.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {

                    log.info("starting expensive task thread %s",
                            Thread.currentThread().getName());
                    Boolean returnedValue = processIntoMongoDBBatch1(batch3);

                    return returnedValue;
                }
            });
            Future<Boolean> task4 = executorService.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {

                    log.info("starting expensive task thread %s",
                            Thread.currentThread().getName());
                    Boolean returnedValue = processIntoMongoDBBatch1(batch4);

                    return returnedValue;
                }
            });
            Future<Boolean> task5 = executorService.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {

                    log.info("starting expensive task thread %s",
                            Thread.currentThread().getName());
                    Boolean returnedValue = processIntoMongoDBBatch1(batch5);

                    return returnedValue;
                }
            });
            Future<Boolean> task6 = executorService.submit(new Callable<Boolean>() {

                public Boolean call() throws Exception {

                    log.info("starting expensive task thread %s",
                            Thread.currentThread().getName());
                    Boolean returnedValue = processIntoMongoDBBatch1(batch6);

                    return returnedValue;
                }
            });

            Boolean value1 = task1.get();
            Boolean value2 = task2.get(4,  TimeUnit.SECONDS);
            Boolean value3 = task2.get(4,  TimeUnit.SECONDS);
            Boolean value4 = task2.get(4,  TimeUnit.SECONDS);
            Boolean value5 = task2.get(4,  TimeUnit.SECONDS);
            Boolean value6 = task2.get(4,  TimeUnit.SECONDS);
           log.info("value1{} ,value2{},value3{},value4{},value5{},value6{}",value1,value2,value3,value4,value5,value6);
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }

   private Boolean processIntoMongoDBBatch1(List<TrainInfo> batch1) {
       List<com.boarding.document.TrainInfo> trains = new ArrayList<>();
       List<com.boarding.document.TrainInfo> trainInfos = null;
       if (batch1.size() != 0) {
           batch1.stream().forEach(trainInfo -> {
               com.boarding.document.TrainInfo trainInfo1 =
                       new com.boarding.document.TrainInfo(trainInfo.getId(), trainInfo.getTrain_number(),
                               trainInfo.getTrain_type(),
                               trainInfo.getDate(),
                               trainInfo.getStation_code(), trainInfo.getStation_type(),
                               trainInfo.getStation_timezone(),
                               trainInfo.getStation_arrival_time(),
                               trainInfo.getStation_train_status(),
                               trainInfo.getStation_departure_time(),
                               trainInfo.getS_checkin_status(),
                               trainInfo.getSp_checkin_status(),
                               trainInfo.getBp_checkin_status(),
                               trainInfo.getArrival_station_code(),
                               trainInfo.getLast_modified_timestamp());
               trains.add(trainInfo1);

           });


           trainInfos = trainInfoMRepository.saveAll(trains);

       }
       if (trainInfos.size() != 0) {
           return true;
       } else {
           return false;
       }
   }
    private Boolean processIntoMongoDBBatch2(List<TrainInfo> batch2) {
        List<com.boarding.document.TrainInfo> trains = new ArrayList<>();
        List<com.boarding.document.TrainInfo> trainInfos = null;
        if (batch2.size() != 0) {
            batch2.stream().forEach(trainInfo -> {
                com.boarding.document.TrainInfo trainInfo1 =
                        new com.boarding.document.TrainInfo(trainInfo.getId(), trainInfo.getTrain_number(),
                                trainInfo.getTrain_type(),
                                trainInfo.getDate(),
                                trainInfo.getStation_code(), trainInfo.getStation_type(),
                                trainInfo.getStation_timezone(),
                                trainInfo.getStation_arrival_time(),
                                trainInfo.getStation_train_status(),
                                trainInfo.getStation_departure_time(),
                                trainInfo.getS_checkin_status(),
                                trainInfo.getSp_checkin_status(),
                                trainInfo.getBp_checkin_status(),
                                trainInfo.getArrival_station_code(),
                                trainInfo.getLast_modified_timestamp());
                trains.add(trainInfo1);

            });


            trainInfos = trainInfoMRepository.saveAll(trains);

        }
        if (trainInfos.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean processIntoMongoDBBatch3(List<TrainInfo> batch3) {
        List<com.boarding.document.TrainInfo> trains = new ArrayList<>();
        List<com.boarding.document.TrainInfo> trainInfos = null;
        if (batch3.size() != 0) {
            batch3.stream().forEach(trainInfo -> {
                com.boarding.document.TrainInfo trainInfo1 =
                        new com.boarding.document.TrainInfo(trainInfo.getId(), trainInfo.getTrain_number(),
                                trainInfo.getTrain_type(),
                                trainInfo.getDate(),
                                trainInfo.getStation_code(), trainInfo.getStation_type(),
                                trainInfo.getStation_timezone(),
                                trainInfo.getStation_arrival_time(),
                                trainInfo.getStation_train_status(),
                                trainInfo.getStation_departure_time(),
                                trainInfo.getS_checkin_status(),
                                trainInfo.getSp_checkin_status(),
                                trainInfo.getBp_checkin_status(),
                                trainInfo.getArrival_station_code(),
                                trainInfo.getLast_modified_timestamp());
                trains.add(trainInfo1);

            });


            trainInfos = trainInfoMRepository.saveAll(trains);

        }
        if (trainInfos.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean processIntoMongoDBBatch4(List<TrainInfo> batch4) {
        List<com.boarding.document.TrainInfo> trains = new ArrayList<>();
        List<com.boarding.document.TrainInfo> trainInfos = null;
        if (batch4.size() != 0) {
            batch4.stream().forEach(trainInfo -> {
                com.boarding.document.TrainInfo trainInfo1 =
                        new com.boarding.document.TrainInfo(trainInfo.getId(), trainInfo.getTrain_number(),
                                trainInfo.getTrain_type(),
                                trainInfo.getDate(),
                                trainInfo.getStation_code(), trainInfo.getStation_type(),
                                trainInfo.getStation_timezone(),
                                trainInfo.getStation_arrival_time(),
                                trainInfo.getStation_train_status(),
                                trainInfo.getStation_departure_time(),
                                trainInfo.getS_checkin_status(),
                                trainInfo.getSp_checkin_status(),
                                trainInfo.getBp_checkin_status(),
                                trainInfo.getArrival_station_code(),
                                trainInfo.getLast_modified_timestamp());
                trains.add(trainInfo1);

            });


            trainInfos = trainInfoMRepository.saveAll(trains);

        }
        if (trainInfos.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean processIntoMongoDBBatch5(List<TrainInfo> batch5) {
        List<com.boarding.document.TrainInfo> trains = new ArrayList<>();
        List<com.boarding.document.TrainInfo> trainInfos = null;
        if (batch5.size() != 0) {
            batch5.stream().forEach(trainInfo -> {
                com.boarding.document.TrainInfo trainInfo1 =
                        new com.boarding.document.TrainInfo(trainInfo.getId(), trainInfo.getTrain_number(),
                                trainInfo.getTrain_type(),
                                trainInfo.getDate(),
                                trainInfo.getStation_code(), trainInfo.getStation_type(),
                                trainInfo.getStation_timezone(),
                                trainInfo.getStation_arrival_time(),
                                trainInfo.getStation_train_status(),
                                trainInfo.getStation_departure_time(),
                                trainInfo.getS_checkin_status(),
                                trainInfo.getSp_checkin_status(),
                                trainInfo.getBp_checkin_status(),
                                trainInfo.getArrival_station_code(),
                                trainInfo.getLast_modified_timestamp());
                trains.add(trainInfo1);

            });


            trainInfos = trainInfoMRepository.saveAll(trains);

        }
        if (trainInfos.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean processIntoMongoDBBatch6(List<TrainInfo> batch6) {
        List<com.boarding.document.TrainInfo> trains = new ArrayList<>();
        List<com.boarding.document.TrainInfo> trainInfos = null;
        if (batch6.size() != 0) {
            batch6.stream().forEach(trainInfo -> {
                com.boarding.document.TrainInfo trainInfo1 =
                        new com.boarding.document.TrainInfo(trainInfo.getId(), trainInfo.getTrain_number(),
                                trainInfo.getTrain_type(),
                                trainInfo.getDate(),
                                trainInfo.getStation_code(), trainInfo.getStation_type(),
                                trainInfo.getStation_timezone(),
                                trainInfo.getStation_arrival_time(),
                                trainInfo.getStation_train_status(),
                                trainInfo.getStation_departure_time(),
                                trainInfo.getS_checkin_status(),
                                trainInfo.getSp_checkin_status(),
                                trainInfo.getBp_checkin_status(),
                                trainInfo.getArrival_station_code(),
                                trainInfo.getLast_modified_timestamp());
                trains.add(trainInfo1);

            });


            trainInfos = trainInfoMRepository.saveAll(trains);

        }
        if (trainInfos.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
