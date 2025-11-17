package com.aigreentick.services.shared.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BlacklistExpiringSoonDto {
    private Long id;
    private String mobile;
    private Long countryId;
    private String type;
    private String reason;
    private LocalDateTime expiresAt;
}
