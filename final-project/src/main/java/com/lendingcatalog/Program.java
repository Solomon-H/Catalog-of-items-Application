package com.lendingcatalog;

import com.lendingcatalog.model.Book;
import com.lendingcatalog.model.Movie;
import com.lendingcatalog.model.Tool;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2018, 2, 2);
        Book book = new Book("The Mind of the Leader", "Rasmus", date1);
        System.out.println(book);

        LocalDate date2 = LocalDate.of(2010, 5, 1);
        Movie movie = new Movie("Jack Bauer", "Washington", date2);
        System.out.println(movie);

        Tool tool = new Tool("Drill", "Lowest", 10);
        System.out.println(tool);
    }
}
