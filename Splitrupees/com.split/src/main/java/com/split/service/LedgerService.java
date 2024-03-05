package com.split.service;

import com.split.dto.LedgerDto;

import java.util.List;

public interface LedgerService {

    LedgerDto createLedger(LedgerDto ledgerDto);
    List<LedgerDto> getAllLedger();
    LedgerDto getLedgerById(int ledgerId);
    LedgerDto getLedgerByName(String ledgerName);
    LedgerDto updateLedger(int ledgerId, LedgerDto ledgerDto);
    void deleteLedger(int ledgerId);
}
