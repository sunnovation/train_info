package com.boarding.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "edcs_station_boarding")
public class TrainInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "train_number")
    private String train_number;
    @Column(name = "train_type")
    private String train_type;
    @Column(name = "date")
    private Date date;
    @Column(name = "station_code")
    private String station_code;
    @Column(name = "station_type")
    private String station_type;
    @Column(name = "station_timezone")
    private String station_timezone;
    @Column(name = "station_arrival_time")
    private String station_arrival_time;
    @Column(name = "station_train_status")
    private String station_train_status;
    @Column(name = "station_departure_time")
    private String station_departure_time;
    @Column(name = "s_checkin_status")
    private String s_checkin_status;
    @Column(name = "sp_checkin_status")
    private String sp_checkin_status;
    @Column(name = "bp_checkin_status")
    private String bp_checkin_status;
    @Column(name = "arrival_station_code")
    private String arrival_station_code;
    @Column(name = "last_modified_timestamp")
    private String last_modified_timestamp;
}
