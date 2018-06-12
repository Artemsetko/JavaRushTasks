package com.javarush.task.task39.task3909;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Testing {
    @Test
    public void testingTruePairsOfStrings(){
        assertTrue(Solution.isOneEditAway("aaaa", "aaaa")); // equal strings
        assertTrue(Solution.isOneEditAway("aaaa", "aaab")); // one symbol changed
        assertTrue(Solution.isOneEditAway("aaaa", "aaaab")); // one symbol added
        assertTrue(Solution.isOneEditAway("baaaa", "aaaa")); // one symbol added
        assertTrue(Solution.isOneEditAway("aaaab", "aaaa")); // one symbol added
        assertTrue(Solution.isOneEditAway("aabaa", "aaaa")); // one symbol added
        assertTrue(Solution.isOneEditAway("rama", "mama"));
        assertTrue(Solution.isOneEditAway("mama", "dama"));
        assertTrue(Solution.isOneEditAway("ama", "mama"));
        assertTrue(Solution.isOneEditAway("mama", "ama"));
        assertTrue(Solution.isOneEditAway("", "")); // empty strings
        assertTrue(Solution.isOneEditAway("", "b")); // empty and 1-symb strings
        assertTrue(Solution.isOneEditAway("b", "")); // empty and 1-symb strings
    }

    @Test
    public void testingFalsePairsOfStrings(){
        assertFalse(Solution.isOneEditAway(null, null)); // nulls
        assertFalse(Solution.isOneEditAway(null, "aaab")); // first is null
        assertFalse(Solution.isOneEditAway("aaaa", null)); // second is null
        assertFalse(Solution.isOneEditAway("aabaa", "aaaca")); // one added symbol in each string
        assertFalse(Solution.isOneEditAway("aaaa", "aaaa  ")); // two added symbols in second
        assertFalse(Solution.isOneEditAway("aaaa", "aabac")); // one change one add in second
        assertFalse(Solution.isOneEditAway("aacbaa", "aaaa")); // two added symbols in first
        assertFalse(Solution.isOneEditAway("aacab", "aaaa")); // one change one add in first
        assertFalse(Solution.isOneEditAway("aaaa", "AAAA")); // diff cases
        assertFalse(Solution.isOneEditAway("mama", "ramas"));
        assertFalse(Solution.isOneEditAway("mamas", "rama"));
        assertFalse(Solution.isOneEditAway("123", "1453"));
        assertFalse(Solution.isOneEditAway("2", "33"));
    }
}
