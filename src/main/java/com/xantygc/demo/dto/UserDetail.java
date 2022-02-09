package com.xantygc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserDetail
{
    private User user;
    private List<Windfarm> windfarmList;
    private List<Forecast> forecastList;
    private List<Settlement> settlementList;
}
