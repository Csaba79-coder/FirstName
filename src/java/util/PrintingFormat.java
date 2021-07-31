package util;

import controller.FirstNameController;
import model.FirstName;

import java.util.List;
import java.util.Set;

public class PrintingFormat {

    public static void printFirstNamesMap() {
        for (List<FirstName> firstNameList : FirstNameController.firstNamesMap.values())
            for (FirstName firstName : firstNameList) {
                System.out.println(firstName);
            }
    }

    public static void printArrayToString(List<String> stringList) {
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public static void printArrayToChar(List<Character> characterList) {
        for (Character ch : characterList) {
            System.out.println(ch);
        }
    }

    public static void printArrayToStringFirstName(List<FirstName> stringList) {
        for (FirstName firstName : stringList) {
            System.out.println(firstName);
        }
    }

    public static void printSetFirstName(Set<FirstName> set) {
        for (FirstName firstName : set) {
            System.out.println(firstName);
        }
    }

    public static void printSet(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void printSeparation() {
        System.out.println("------------------------------------");
    }
}
