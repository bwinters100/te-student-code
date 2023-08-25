package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Movie implements CatalogItem {
    private String id;
    private final String name;
    private final String director;
    private final LocalDate releaseDate;

    public Movie(String name, String director, LocalDate releaseDate){
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public String toString(){
        return "* " + name + System.lineSeparator()
                + " - Directed by: " + director + System.lineSeparator()
                + " - Released: " + releaseDate + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return name.toLowerCase(Locale.ROOT).contains(searchStr.toLowerCase(Locale.ROOT));
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return director.toLowerCase(Locale.ROOT).contains(searchStr.toLowerCase(Locale.ROOT));
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return releaseDate.equals(searchYear);
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(LocalDate.now() + this.toString() + " was registered", "Movies.log", true);
        } catch (FileStorageException e) {
            System.out.println(e.getMessage());
        }
    }
}
