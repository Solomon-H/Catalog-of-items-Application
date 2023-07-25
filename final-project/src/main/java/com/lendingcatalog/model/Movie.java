package com.lendingcatalog.model;
import java.time.LocalDate;
import java.util.UUID;
import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

public class Movie implements CatalogItem {
    // attribute of the class.
   private String id;
   private String name;
   private String director;
   private LocalDate releaseDate;

    // movie constructor that takes parameters
    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    // getter method
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    // overriding method
    @Override
    public boolean matchesName(String searchStr) {
        return name.toLowerCase().contains(searchStr.toLowerCase());
    }

    //This method find and return the matching director of the movie
    @Override
    public boolean matchesCreator(String searchStr) {
        return director.toLowerCase().contains(searchStr.toLowerCase());
    }

    //This method find and return the matching releaseDate of the movie
    @Override
    public boolean matchesYear(int searchYear) {
        return releaseDate.getYear() == searchYear;
    }


    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(toString(),"src/main/resources/logs/movie.log", true);
        } catch (FileStorageException e) {
            System.out.println("unable to log movie ");
        }

    }

    // The toString method is used to convert to the string
    @Override
     public String toString() {
            return "* " + name + System.lineSeparator()
                    + " - Director by: " + director + System.lineSeparator()
                    + " - Published: " + releaseDate + System.lineSeparator()
                    + " - Id: " + id;

        }

    }

