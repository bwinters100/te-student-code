package com.techelevator.dao;

import com.techelevator.model.DictionaryEntry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AltJdbcDictionaryEntryDao implements DictionaryEntryDao{
    private final JdbcTemplate template;
    private static final RowMapper<DictionaryEntry> MAPPER = new RowMapper<DictionaryEntry>() {
        @Override
        public DictionaryEntry mapRow(ResultSet rs, int i) throws SQLException {
            return new DictionaryEntry(rs.getString("word"), rs.getString("definition"));
        }
    };


    public AltJdbcDictionaryEntryDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<DictionaryEntry> getAllDictionaryEntries() {
        return template.query("select * from entry", MAPPER);
    }

    @Override
    public DictionaryEntry getDictionaryEntryByWord(String word) {
        // what about this? ...
        // dog';delete from entry;select * from entry where word = 'cat
        List<DictionaryEntry> entries = template.query("select * from entry where word ILIKE '" + word + "'", MAPPER);
        return entries.isEmpty() ? null : entries.get(0);
    }
}
