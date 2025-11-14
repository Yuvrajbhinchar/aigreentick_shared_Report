package com.aigreentick.services.shared.reports.service;

import com.aigreentick.services.shared.reports.dto.BlacklistStatusReportDto;
import com.aigreentick.services.shared.reports.dto.CountryBlacklistCountDto;
import com.aigreentick.services.shared.reports.repository.BlacklistReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlacklistReportService {

    private final BlacklistReportRepository blacklistRepository;

    public BlacklistStatusReportDto getBlacklistStatusReport() {
        long active = blacklistRepository.countActive();
        long expired = blacklistRepository.countExpired();
        return new BlacklistStatusReportDto(active, expired);
    }

    public List<CountryBlacklistCountDto> getBlacklistCountByCountry() {

        List<Object[]> rows = blacklistRepository.getBlacklistCountByCountry();

        return rows.stream().map(row ->
                new CountryBlacklistCountDto(
                        ((Number) row[0]).longValue(),      // countryId
                        (String) row[1],                    // countryName
                        ((Number) row[2]).longValue()       // totalBlacklisted
                )
        ).collect(Collectors.toList());
    }
}
