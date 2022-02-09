package com.xantygc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Settlement
{
    private LocalDate date;
    private BigDecimal amount;
}
