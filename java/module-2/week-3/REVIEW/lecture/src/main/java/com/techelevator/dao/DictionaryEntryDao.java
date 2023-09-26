package com.techelevator.dao;

import com.techelevator.model.DictionaryEntry;

import java.util.List;

public interface DictionaryEntryDao {
    List<DictionaryEntry> getAllDictionaryEntries();
    DictionaryEntry getDictionaryEntryByWord( String word );
}
