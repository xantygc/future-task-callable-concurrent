package com.xantygc.demo.service;

import com.xantygc.demo.dto.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;

public class UserService
{

    private SettlementService settlementService = new SettlementService();
    private WindfarmService windfarmService = new WindfarmService();
    private ForecastService forecastService = new ForecastService();

    Logger logger = Logger.getLogger(UserService.class.getName());

    public UserDetail findBySequential(String username) throws InterruptedException
    {
        long startTime = System.currentTimeMillis();
        User user = new User(username);
        List<Windfarm> windfarmList = windfarmService.findAll(user);
        List<Forecast> forecastList = forecastService.findAll(user);
        List<Settlement> settlementList = settlementService.findAll(user);
        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Elapsed time [" + elapsedTime + "]");
        return new UserDetail(user, windfarmList, forecastList,  settlementList);
    }

    public UserDetail findByParallel(String username) throws InterruptedException, ExecutionException
    {
        long startTime = System.currentTimeMillis();
        User user = new User(username);
        Callable<List<Windfarm>> windfarmCall = () -> windfarmService.findAll(user);
        Callable<List<Forecast>> forecastCall = () -> forecastService.findAll(user);
        Callable<List<Settlement>> settlementCall = () -> settlementService.findAll(user);

        FutureTask<List<Windfarm>> windfarmFuture = new FutureTask<>(windfarmCall);
        FutureTask<List<Forecast>> forecastFuture = new FutureTask<>(forecastCall);
        FutureTask<List<Settlement>> settlementFuture = new FutureTask<>(settlementCall);

        new Thread(windfarmFuture).start();
        new Thread(forecastFuture).start();
        new Thread(settlementFuture).start();

        UserDetail userDetail = new UserDetail(user, windfarmFuture.get(), forecastFuture.get(), settlementFuture.get());

        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Elapsed time [" + elapsedTime + "]");
        return userDetail;
    }
}
