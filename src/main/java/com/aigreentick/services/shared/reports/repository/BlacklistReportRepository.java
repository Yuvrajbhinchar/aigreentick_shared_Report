package com.aigreentick.services.shared.reports.repository;

import com.aigreentick.services.shared.model.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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

    @Query(value = """
        SELECT 
            c.id AS country_id,
            c.name AS country_name,
            COUNT(b.id) AS total_blacklisted
        FROM countries c
        LEFT JOIN blacklists b 
            ON b.country_id = c.id 
            AND b.is_deleted = false 
            AND c.is_deleted = false
        GROUP BY c.id, c.name
        ORDER BY total_blacklisted DESC
        """, nativeQuery = true)
    List<Object[]> getBlacklistCountByCountry();

    @Query(value = """
            SELECT
            b.type AS type,
            COUNT(b.id) AS total_count
            FROM blacklists b
            WHERE b.is_deleted = false
    GROUP BY b.type
    ORDER BY total_count DESC
    """, nativeQuery = true)
    List<Object[]> getBlacklistCountByType();
}
