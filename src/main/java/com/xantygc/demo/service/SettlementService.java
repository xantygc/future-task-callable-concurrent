package com.xantygc.demo.service;

import com.xantygc.demo.dto.Settlement;
import com.xantygc.demo.dto.User;

import java.util.List;

public class SettlementService
{
    public List<Settlement> findAll(User user) throws InterruptedException
    {
        Thread.sleep(1000); return null;
    }
}
