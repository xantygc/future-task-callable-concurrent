package com.xantygc.demo.service;

import com.xantygc.demo.dto.Forecast;
import com.xantygc.demo.dto.User;

import java.util.List;

public class ForecastService
{

    public List<Forecast> findAll(User user) throws InterruptedException
    {
        Thread.sleep(1000);
        return null;
    }
}
