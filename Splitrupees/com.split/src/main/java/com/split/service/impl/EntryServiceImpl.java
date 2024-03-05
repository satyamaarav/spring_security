package com.split.service.impl;

import com.split.dto.EntryDto;
import com.split.entity.Entry;
import com.split.repository.EntryRepo;
import com.split.service.EntryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepo entryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EntryDto createEntry(EntryDto entryDto) {
        Entry entry = modelMapper.map(entryDto, Entry.class);
        Entry savedEntry = entryRepo.save(entry);
        return modelMapper.map(savedEntry, EntryDto.class);
    }

    @Override
    public List<EntryDto> getAllEntry() {
        List<Entry> entries = entryRepo.findAll();
        return entries.stream()
                .map(entry -> modelMapper.map(entry, EntryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EntryDto getEntryById(int entryId) {
        Optional<Entry> optionalEntry = entryRepo.findById(entryId);
        return optionalEntry.map(entry -> modelMapper.map(entry, EntryDto.class)).orElse(null);
    }

    @Override
    public EntryDto updateEntry(int entryId, EntryDto entryDto) {
        Optional<Entry> optionalEntry = entryRepo.findById(entryId);

        if (optionalEntry.isPresent()) {
            Entry existingEntry = optionalEntry.get();
            modelMapper.map(entryDto, existingEntry);
            Entry updatedEntry = entryRepo.save(existingEntry);
            return modelMapper.map(updatedEntry, EntryDto.class);
        }

        return null; // Entry with given ID not found
    }

    @Override
    public void deleteEntry(int entryId) {
        entryRepo.deleteById(entryId);
    }
}
