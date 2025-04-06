package com.dailyfile.journal.controller;

import com.dailyfile.journal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
class JournalEntryController_v2 {
    private Map<Long, JournalEntry> JournalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(JournalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        JournalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntry(@PathVariable long myId){
        return JournalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntry(@PathVariable long myId){
        return JournalEntries.remove(myId);
    }
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntry(@PathVariable long id, @RequestBody JournalEntry myEntry){
        return JournalEntries.put(id, myEntry);
    }
}
