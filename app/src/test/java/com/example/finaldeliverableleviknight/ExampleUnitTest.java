package com.example.finaldeliverableleviknight;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void calculateFamAndPlayerNumberIfListOfSix() {
        HashMap<String, String> temp = new HashMap<String, String>();
        LinkedList<String> listOfSix = new LinkedList<String>();
        listOfSix.add("John");
        listOfSix.add("Jim");
        listOfSix.add("Jane");
        listOfSix.add("Jake");
        listOfSix.add("Jess");
        listOfSix.add("Joe");

        LinkedList<String> someLength = new Family(temp).calculateFamAndPlayerNumber(listOfSix);

        assertEquals(listOfSix.size(), someLength.size());
    }

    @Test
    public void createFamilyNamesListIfHashMapOfZero() {
        HashMap<String, String> temp = new HashMap<>();
        Family family = new Family(temp);

        LinkedList<String> list = family.createFamilyNamesList();

        assertEquals(list.getFirst(), "Sorry, You need more family.");
    }

    @Test
    public void createFamilyNamesListIfHashMapOfFivePeople() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("TestFamily1", "2");
        temp.put("TestFamily2", "3");
        Family family = new Family(temp);

        LinkedList<String> list = family.createFamilyNamesList();

        assertEquals(list.size(), 5);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}