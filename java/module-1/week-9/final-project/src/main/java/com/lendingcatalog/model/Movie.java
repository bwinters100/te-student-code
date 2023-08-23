package com.lendingcatalog.model;

import java.time.LocalDate;

public class Movie implements CatalogItem {
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

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
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {

    }
}
