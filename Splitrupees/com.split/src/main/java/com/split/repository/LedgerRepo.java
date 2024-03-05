package com.split.repository;

import com.split.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerRepo extends JpaRepository<Ledger,Integer> {
    Ledger findByLedgerName(String ledgerName);
}
