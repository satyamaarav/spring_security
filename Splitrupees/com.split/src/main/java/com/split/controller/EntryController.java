package com.split.controller;

import com.split.dto.EntryDto;
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
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/entries")
    public ResponseEntity<EntryDto> createEntry(@RequestBody EntryDto entryDto) {
        EntryDto createdEntry = entryService.createEntry(entryDto);
        return new ResponseEntity<>(createdEntry, HttpStatus.CREATED);
    }

    @GetMapping("/entries")
    public ResponseEntity<List<EntryDto>> getAllEntries() {
        List<EntryDto> entries = entryService.getAllEntry();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @GetMapping("/entries/{entryId}")
    public ResponseEntity<EntryDto> getEntryById(@PathVariable int entryId) {
        EntryDto entry = entryService.getEntryById(entryId);
        return (entry != null)
                ? new ResponseEntity<>(entry, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/entries/{entryId}")
    public ResponseEntity<EntryDto> updateEntry(@PathVariable int entryId, @RequestBody EntryDto entryDto) {
        EntryDto updatedEntry = entryService.updateEntry(entryId, entryDto);
        return (updatedEntry != null)
                ? new ResponseEntity<>(updatedEntry, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/entries/{entryId}")
    public ResponseEntity<Void> deleteEntry(@PathVariable int entryId) {
        entryService.deleteEntry(entryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
