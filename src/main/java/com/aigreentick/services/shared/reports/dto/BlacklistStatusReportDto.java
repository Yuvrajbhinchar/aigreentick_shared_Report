package com.aigreentick.services.shared.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistStatusReportDto {
    private long activeCount;
    private long expiredCount;
}
