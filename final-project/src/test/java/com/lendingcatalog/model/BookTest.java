package com.lendingcatalog.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class BookTest {
    Book book1;
    @Before
    public void setup() {
        LocalDate date = LocalDate.of(2022, 1, 20);
        book1 = new Book("Little Blue Truck's Valentine", "Alice Schertle", date);
    }


    @Test
    public void matchesName() {
        Assert.assertTrue(book1.matchesName("Blue"));
    }

    @Test
    public void matchesCreator() {
        Assert.assertTrue(book1.matchesCreator("Alice"));
    }

    @Test
    public void matchesYear() {
        Assert.assertTrue(book1.matchesYear(2022));
    }
}