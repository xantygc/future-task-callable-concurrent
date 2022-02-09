package com.xantygc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Forecast
{
    private BigDecimal[] values;
}
