package com.example.anagram;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.EditString;


public class EditStringTest {

    // Foxminded cool 24/7 -> dexdnimoF oocl 7/42, abcd efgh -> dcba hgfe, Foxminded cool 24/7 -> dednimxoF looc 24/7, abcd -> dcba

    EditString edstr = new EditString();

    @Test
    public void testEditStringChar() {
        assertEquals("dexdnimoF oocl 7/42", edstr.editString("Foxminded cool 24/7", "xl"));
    }

    @Test
    public void testEditStringNum() {
        assertEquals("dcba hgfe", edstr.editString("abcd efgh", "0123456789/"));
    }

    @Test
    public void testEditStringNum1() {
        assertEquals("dednimxoF looc 24/7", edstr.editString("Foxminded cool 24/7", "0123456789/"));
    }

    @Test
    public void testEditStringNum2() {
        assertEquals("dednimxoF123456789", edstr.editString("Foxminded123456789", "0123456789/"));
    }

    @Test
    public void testReverse() {
        assertEquals("dcba", edstr.editString("abcd", "0123456789/"));
    }

    @Test
    public void testReverse1() {
        assertEquals("0123456789", edstr.editString("0123456789", "0123456789/"));
    }

}


