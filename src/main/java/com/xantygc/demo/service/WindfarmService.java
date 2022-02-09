package com.xantygc.demo.service;

import com.xantygc.demo.dto.User;
import com.xantygc.demo.dto.Windfarm;

import java.util.List;

public class WindfarmService
{
    public List<Windfarm> findAll(User user) throws InterruptedException
    {
        Thread.sleep(1000);
        return null;
    }
}
