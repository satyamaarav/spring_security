package com.split.service;

import com.split.dto.EntryDto;

import java.util.List;

public interface EntryService {

    public EntryDto createEntry(EntryDto entryDto);
    public List<EntryDto> getAllEntry();
    public EntryDto getEntryById(int entryId);
    public EntryDto updateEntry(int entryId, EntryDto entryDto);
    public void deleteEntry(int entryId);
}
