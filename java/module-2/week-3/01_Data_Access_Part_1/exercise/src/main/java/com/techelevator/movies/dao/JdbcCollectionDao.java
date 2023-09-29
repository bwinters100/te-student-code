package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from collection");
        while(rs.next()){
            Collection collection = mapCollection(rs);
            collections.add(collection);
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from collection where collection_id = ?", id);
        if(rs.next()){
            Collection collection = mapCollection(rs);
            return collection;
        }
        return null;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collections = new ArrayList<>();
        if(useWildCard){
            name = "%" + name + "%";
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from collection where collection_name ILIKE ?", name );
        while(rs.next()){
            collections.add(mapCollection(rs));
        }
        return collections;

    }

    private static Collection mapCollection(SqlRowSet rs){
        int id = rs.getInt("collection_id");
        String name = rs.getString("collection_name");
        Collection collection = new Collection();
        collection.setId(id);
        collection.setName(name);
        return collection;
    }
}
