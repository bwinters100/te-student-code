package com.techelevator.dao;

import com.techelevator.model.DictionaryEntry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDictionaryEntryDao implements DictionaryEntryDao{
    private final JdbcTemplate template;

    public JdbcDictionaryEntryDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<DictionaryEntry> getAllDictionaryEntries() {
        return null;
    }

    @Override
    public DictionaryEntry getDictionaryEntryByWord(String word) {
        return null;
    }
}
