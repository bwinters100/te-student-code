package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Book implements CatalogItem{
    private String id;
    private static String title;
    private static String author;
    private static LocalDate publishDate;

    public Book(String title, String author, LocalDate publishDate){
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String toString(){
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return title.toLowerCase(Locale.ROOT).contains(searchStr.toLowerCase(Locale.ROOT));
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return author.toLowerCase(Locale.ROOT).contains(searchStr.toLowerCase(Locale.ROOT));
    }

    @Override
    public boolean matchesYear(int searchYear) {
        
        return publishDate.equals(searchYear);

    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(LocalDate.now() + this.toString() + " was registered", "Books.log", true);
        } catch (FileStorageException e) {
            System.out.println(e.getMessage());
        }

    }
}
