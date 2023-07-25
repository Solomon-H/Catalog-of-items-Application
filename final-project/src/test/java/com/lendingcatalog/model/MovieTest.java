package com.lendingcatalog.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class MovieTest {

    Movie movie1;

    @Before
    public void setup() {
        LocalDate date = LocalDate.of(2022, 1, 20);
        movie1 = new Movie("House Party", "Reginald Hudlin", date);
    }


    @Test
    public void matchesName() {
        Assert.assertTrue(movie1.matchesName("Party"));
    }

    @Test
    public void matchesCreator() {
        Assert.assertTrue(movie1.matchesCreator("Hudlin"));

    }

    @Test
    public void matchesYear() {
        Assert.assertTrue(movie1.matchesYear(2022));

    }
}