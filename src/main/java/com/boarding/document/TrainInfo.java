package com.boarding.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainInfo {
    @Id
    private Integer id;

    private String train_number;
    private String train_type;
    private Date date;
    private String station_code;
    private String station_type;
    private String station_timezone;
    private String station_arrival_time;
    private String station_train_status;
    private String station_departure_time;
    private String s_checkin_status;
    private String sp_checkin_status;
    private String bp_checkin_status;
    private String arrival_station_code;
    private String last_modified_timestamp;

}
