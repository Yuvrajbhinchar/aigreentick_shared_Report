package com.aigreentick.services.shared.reports.repository;

import com.aigreentick.services.shared.model.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlacklistReportRepository extends JpaRepository<Blacklist, Long> {

    // Count currently active blacklists
    @Query("""
        SELECT COUNT(b)
        FROM Blacklist b
        WHERE b.isBlocked = true AND (b.expiresAt IS NULL OR b.expiresAt > CURRENT_TIMESTAMP)
    """)
    long countActive();

    // Count expired blacklists
    @Query("""
        SELECT COUNT(b)
        FROM Blacklist b
        WHERE b.isBlocked = false OR (b.expiresAt IS NOT NULL AND b.expiresAt <= CURRENT_TIMESTAMP)
    """)
    long countExpired();
}
