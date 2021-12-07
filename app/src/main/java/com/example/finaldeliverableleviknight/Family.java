package com.example.finaldeliverableleviknight;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Family {

    HashMap<String, String> familiesAndNumberOf;

    public Family(@NonNull HashMap s) {
        familiesAndNumberOf = s;
    }

    public LinkedList<String> createFamilyNamesList() {
        LinkedList<String> theList;
        LinkedList<String> namesList = new LinkedList<>();      // Recreates the Hashmap everytime the SecoundActivity is created
        familiesAndNumberOf.forEach((name, number) -> {         // For each family with more than one member we need to duplicate the last name and create a unique number for that person.

            int i;
            try{
                i = Integer.parseInt(number);

                int x = 1;
                while (x <= i) {                                // For each family member create an entry in the List with their last name and number.
                    namesList.add((String)name + " Member #" + String.valueOf(x));
                    x += 1;
                }
            } catch(Exception e) {                      // This is a triple check of the passed user input values
                System.err.println("CATCH. CATCH. CATCH. CATCH. CATCH. When parsing names and numbers;");
            }
        });

        if (namesList.size() > 0) {                     // Gives an error message if there was no input form the user
            theList = calculateFamAndPlayerNumber(namesList);
        } else {
            theList = new LinkedList<String>();
            theList.add("Sorry, You need more family.");
        }
        return theList;
    }

    public LinkedList<String> calculateFamAndPlayerNumber(LinkedList<String> passedList) {

        LinkedList<String> returnList = new LinkedList<String>();
        LinkedList<String> reciversNumbers = (LinkedList<String>) passedList.clone();
                                            // passedList is copied and then only used for keeping track for how many people there are.
                                            // reciversNumbers is used to keep track of who has been assigned a giver.
                                            // returnList is the new list that has giver and receiver and wil be displayed.
        int randomInt;
        int x = 0;
        String newReciever;

        while (x < passedList.size()) {

            randomInt = new Random().nextInt(reciversNumbers.size());       // Randomly picks a index of a person from the list of people who have not yet had a giver assigned

            newReciever = reciversNumbers.get(randomInt);                   // Creates a copy of the selected person

            reciversNumbers.remove(randomInt);                              // Removes the selected person from the unassigned list

            returnList.add(passedList.get(x) + " will give a gift to\r\n" + newReciever);   // Adds the giver and the receiver to the new list

            x += 1;                                                         // Increases count to iterate through the list of givers
        }

        return returnList;
    }
}
