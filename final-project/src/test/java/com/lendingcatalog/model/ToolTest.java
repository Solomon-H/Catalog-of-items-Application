package com.lendingcatalog.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToolTest {
    Tool tool;
    @Before
    public void setup(){
        tool = new Tool("Engraver", "Hardell", 10);
    }

    @Test
    public void matchesName() {
        Assert.assertTrue(tool.matchesName("Engraver"));
    }

    @Test
    public void matchesCreator() {
        Assert.assertTrue(tool.matchesCreator("Hardell"));
    }
}