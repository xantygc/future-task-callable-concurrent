package com.xantygc.demo.service.launcher;

import com.xantygc.demo.service.UserService;

import java.util.concurrent.ExecutionException;

public class ExampleRunner
{
    public static void main (String[] args) throws InterruptedException, ExecutionException
    {
        UserService userService = new UserService();
        userService.findByParallel("Menganito");
    }
}
