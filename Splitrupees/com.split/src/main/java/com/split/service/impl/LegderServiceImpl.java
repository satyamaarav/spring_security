package com.split.service.impl;

import com.split.dto.LedgerDto;
import com.split.entity.Ledger;
import com.split.entity.User;
import com.split.exception.ResourceNotFoundException;
import com.split.repository.LedgerRepo;
import com.split.repository.UserRepo;
import com.split.service.LedgerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LegderServiceImpl implements LedgerService {

    @Autowired
    private LedgerRepo ledgerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public LedgerDto createLedger(LedgerDto ledgerDto) {
        Ledger ledger = modelMapper.map(ledgerDto, Ledger.class);
        var user = this.userRepo.findById(ledger.getUserId());
        if(user.isPresent()){
            Ledger savedLedger = ledgerRepo.save(ledger);
            return modelMapper.map(savedLedger, LedgerDto.class);
        }
        return null;
    }

    @Override
    public List<LedgerDto> getAllLedger() {
        List<Ledger> ledgers = ledgerRepo.findAll();
        return ledgers.stream()
                .map(ledger -> modelMapper.map(ledger, LedgerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LedgerDto getLedgerById(int ledgerId) {
        Optional<Ledger> optionalLedger = ledgerRepo.findById(ledgerId);
        return optionalLedger.map(ledger -> modelMapper.map(ledger, LedgerDto.class)).orElse(null);
    }

    @Override
    public LedgerDto getLedgerByName(String ledgerName) {
        Ledger ledger = ledgerRepo.findByLedgerName(ledgerName);
        return (ledger != null) ? modelMapper.map(ledger, LedgerDto.class) : null;
    }

    @Override
    public LedgerDto updateLedger(int ledgerId, LedgerDto ledgerDto) {
        Optional<Ledger> optionalLedger = ledgerRepo.findById(ledgerId);

        if (optionalLedger.isPresent()) {
            Ledger existingLedger = optionalLedger.get();
            modelMapper.map(ledgerDto, existingLedger);
            Ledger updatedLedger = ledgerRepo.save(existingLedger);
            return modelMapper.map(updatedLedger, LedgerDto.class);
        }

        return null; // Ledger with given ID not found
    }

    @Override
    public void deleteLedger(int ledgerId) {
        ledgerRepo.deleteById(ledgerId);
    }
}
