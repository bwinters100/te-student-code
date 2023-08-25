package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Tool implements CatalogItem{
    private String id;
    private static String type;
    private static String manufacturer;
    private int count;

    public Tool(String type, String manufacturer, int count){
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public String toString(){
        return "* " + type + System.lineSeparator()
                + " - Manufactured by: " + manufacturer + System.lineSeparator()
                + " - Count is: " + count + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return type.toLowerCase(Locale.ROOT).contains(searchStr.toLowerCase(Locale.ROOT));
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return manufacturer.toLowerCase(Locale.ROOT).contains(searchStr.toLowerCase(Locale.ROOT));
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(LocalDate.now() + this.toString() + " was registered", "Tools.log", true);
        } catch (FileStorageException e) {
            System.out.println(e.getMessage());
        }
    }
}
