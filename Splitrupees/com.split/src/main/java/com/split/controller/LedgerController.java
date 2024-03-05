package com.split.controller;

import com.split.dto.LedgerDto;
import com.split.service.LedgerService;
import com.split.service.EntryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/split")
@SecurityRequirement(name = "bearerAuth")
public class LedgerController {

    @Autowired
    private LedgerService ledgerService;

    @Autowired
    private EntryService entryService;

    @PostMapping("/ledgers")
    public ResponseEntity<LedgerDto> createLedger(@RequestBody LedgerDto ledgerDto) {

        LedgerDto createdLedger = ledgerService.createLedger(ledgerDto);
        return new ResponseEntity<>(createdLedger, HttpStatus.CREATED);
    }

    @GetMapping("/ledgers")
    public ResponseEntity<List<LedgerDto>> getAllLedgers() {
        List<LedgerDto> ledgers = ledgerService.getAllLedger();
        return new ResponseEntity<>(ledgers, HttpStatus.OK);
    }

    @GetMapping("/ledgers/{ledgerId}")
    public ResponseEntity<LedgerDto> getLedgerById(@PathVariable int ledgerId) {
        LedgerDto ledger = ledgerService.getLedgerById(ledgerId);
        return (ledger != null)
                ? new ResponseEntity<>(ledger, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ledgers/name/{ledgerName}")
    public ResponseEntity<LedgerDto> getLedgerByName(@PathVariable String ledgerName) {
        LedgerDto ledger = ledgerService.getLedgerByName(ledgerName);
        return (ledger != null)
                ? new ResponseEntity<>(ledger, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/ledgers/{ledgerId}")
    public ResponseEntity<LedgerDto> updateLedger(@PathVariable int ledgerId, @RequestBody LedgerDto ledgerDto) {
        LedgerDto updatedLedger = ledgerService.updateLedger(ledgerId, ledgerDto);
        return (updatedLedger != null)
                ? new ResponseEntity<>(updatedLedger, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/ledgers/{ledgerId}")
    public ResponseEntity<Void> deleteLedger(@PathVariable int ledgerId) {
        ledgerService.deleteLedger(ledgerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

