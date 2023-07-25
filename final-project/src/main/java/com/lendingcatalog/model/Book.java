package com.lendingcatalog.model;
import java.time.LocalDate;
import java.util.UUID;
import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

public class Book implements CatalogItem {
    // attributes of the class
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;

    // book constructor that takes parameters
    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    // getter method
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    // overriding method
    @Override
    public boolean matchesName(String searchStr) {
        return title.toLowerCase().contains(searchStr.toLowerCase());
    }

    //This method find and return the matching author of the book.
    @Override
    public boolean matchesCreator(String searchStr) {
        return author.toLowerCase().contains(searchStr.toLowerCase());
    }

    //This method find and return the matching publishDate of the book.
    @Override
    public boolean matchesYear(int searchYear) {
        return publishDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(toString(),"src/main/resources/logs/book.log", true);
        } catch (FileStorageException e) {
            System.out.println("unable to log book");
        }

    }

    // The toString method is used to convert the class data to a string.
    @Override
    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }

}