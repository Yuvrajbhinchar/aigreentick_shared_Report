package com.aigreentick.services.shared.reports.controller;

import com.aigreentick.services.shared.reports.dto.BlacklistStatusReportDto;
import com.aigreentick.services.shared.reports.dto.BlacklistTypeCountDto;
import com.aigreentick.services.shared.reports.dto.CountryBlacklistCountDto;
import com.aigreentick.services.shared.reports.service.BlacklistReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class BlacklistReportController {

    private final BlacklistReportService blacklistReportService;


    @GetMapping("/blacklist-status")
    public ResponseEntity<BlacklistStatusReportDto> getBlacklistStatus(){
        BlacklistStatusReportDto report = blacklistReportService.getBlacklistStatusReport();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/blacklist-by-country")
    public ResponseEntity<List<CountryBlacklistCountDto>> getBlacklistCountByCountry() {
        return ResponseEntity.ok(blacklistReportService.getBlacklistCountByCountry());
    }

    @GetMapping("/blacklist-by-type")
    public ResponseEntity<List<BlacklistTypeCountDto>> getBlacklistCountByType() {
        return ResponseEntity.ok(blacklistReportService.getBlacklistCountByType());
    }
}
