package com.boarding.service;

import com.boarding.dao.TrainInfoMRepository;
import com.boarding.dao.TrainInfoRepository;
import com.boarding.entity.TrainInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BoardingService {


    int failIndx=0;
    @Autowired
    TrainInfoRepository trainInfoRepository;

    @Autowired
    TrainInfoMRepository trainInfoMRepository;
    @Autowired
    OptimizedTrainInfoSolution optimizedTrainInfoSolution;

    public void processData(){
        HashMap<String,Object> response=new HashMap<>();
        List<TrainInfo> trainInfos=trainInfoRepository.findAll();
        List<com.boarding.document.TrainInfo> trainsPersisist=new ArrayList<>();
//      List<TrainInfo> trainInfos=trainInfoRepository.findtrainData();
        log.info("Data"+trainInfos.size());
        optimizedTrainInfoSolution.processDataintoOptimized(trainInfos);


    }


    public void notificationOfBoarding() {
        List<String> failureList=new ArrayList<>();
        List<TrainInfo> trainsProcess=trainInfoRepository.findAll();
        List<com.boarding.document.TrainInfo> trains=trainInfoMRepository.findAll();
        if(trains.size()!=0){
          List<String> trainNumbers=  trains.stream().map(train->{
                return train.getTrain_number();
            }).collect(Collectors.toUnmodifiableList());
            List<String> trainNumberActual=  trainsProcess.stream().map(train->{
                return train.getTrain_number();
            }).collect(Collectors.toUnmodifiableList());
            if(trainNumbers.size()<=trainNumberActual.size()) {
                for (int indx = 0; indx < trainNumbers.size(); indx++) {
                    if (trainNumbers.get(indx).equalsIgnoreCase(trainNumberActual.get(indx))) {

                    }else{
                        failureList.add(trainNumbers.get(indx));

                    }
                }
            }
            nottificationOfFailure(failureList);
        }



    }

    private void nottificationOfFailure(List<String> failureList) {
     StringBuilder msg=new StringBuilder();

        msg.append("Dear Team,\n\n" +
                "The following train data are missing into given "+ LocalDate.now()+"\n\n ");
        failureList.stream().forEach(trainNumber->{
            failIndx++;
            msg.append(failIndx+" "+trainNumber+"\n");
        });
        msg.append("\n\n\n\nThanks & Regards\n\n" +
                "Tech team ");

       send("barthunia1996@gmail.com", "PoojaSaini@92", "pawanbarthunia@gmail.com", "Not processed train data", msg.toString());

    }




    public static void send(String from,String password,String to,String sub,String msg){
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.port", "465");
        //get Session
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(from,password);
//                    }
//                });
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "barthunia1996@gmail.com", "Poojasaini@92");// Specify the Username and the PassWord
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);

            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {throw new RuntimeException(e);}

    }



}
