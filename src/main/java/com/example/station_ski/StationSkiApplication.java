package com.example.station_ski;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StationSkiApplication {


    public static void main(String[] args) {
        SpringApplication.run(StationSkiApplication.class, args);
    }

}
