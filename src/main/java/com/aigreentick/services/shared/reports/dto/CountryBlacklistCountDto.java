package com.aigreentick.services.shared.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryBlacklistCountDto {
    private Long countryId;
    private String countryName;
    private long totalBlacklisted;
}
