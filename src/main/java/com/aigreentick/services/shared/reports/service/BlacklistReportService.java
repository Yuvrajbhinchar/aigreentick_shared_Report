package com.aigreentick.services.shared.reports.service;

import com.aigreentick.services.shared.reports.dto.BlacklistStatusReportDto;
import com.aigreentick.services.shared.reports.repository.BlacklistReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlacklistReportService {

    private final BlacklistReportRepository blacklistRepository;

    public BlacklistStatusReportDto getBlacklistStatusReport() {
        long active = blacklistRepository.countActive();
        long expired = blacklistRepository.countExpired();
        return new BlacklistStatusReportDto(active, expired);
    }
}
