package com.learning.gcs.gateway.service;

public interface ScheduleService {

    void clearTaskHourCount();

    void generateCurrentHourTask();

    void synPhoneNumber();
}
