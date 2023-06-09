package com.example.client_ws_supermarket.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StatisticTimeRequest {
    LocalDate localDate;
    String optionSelect;
}
