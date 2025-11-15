package com.aigreentick.services.shared.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlacklistTypeCountDto {
    private String type;
    private long totalCount;
}
