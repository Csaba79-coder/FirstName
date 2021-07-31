package controller;

import model.FirstName;
import model.Gender;
import util.FileHandler;
import util.PrintingFormat;
import java.io.IOException;
import java.util.*;

public class FirstNameController {

    public static Map<Gender, List<FirstName>> firstNamesMap = new HashMap<>();
    private static final Map<Character, List<FirstName>> CHARACTER_MAP = new HashMap<>();
    private static final String MY_NAME = "Csaba";
    private static final Object[] ARGS = new Object[]{"héber", "latin", "görög"};
    private static final Object[] ARGS_2 = new Object[]{"héber", "latin"};

    public static void runFirstSecondThird() throws IOException {
        FileHandler.read();
    }

    public static void runFourth() {
        PrintingFormat.printFirstNamesMap();
    }

    public static void runFifth() {
        List<String> myNameMeans = meaningOfYourName(MY_NAME);
        PrintingFormat.printArrayToString(myNameMeans);
    }

    private static List<String> meaningOfYourName(String name) {
        List<String> noSuchName = Arrays.asList("There is no such name in our list!", "Sorry!!!");
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getFirstName().equals(name))
                    return firstName.getMeaning();
            }
        }
        return noSuchName;
    }

    public static List<Character> runSixth() {
        return getTheMostPopularInitial(CHARACTER_MAP);
    }

    private static int findMaxChar() {
        int max = 0;

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                CHARACTER_MAP.putIfAbsent(firstName.getFirstName().charAt(0), new ArrayList<>());
                CHARACTER_MAP.get(firstName.getFirstName().charAt(0)).add(firstName);
                for (Map.Entry<Character, List<FirstName>> entry : CHARACTER_MAP.entrySet()) {
                    if (entry.getValue().size() > max) {
                        max = entry.getValue().size();
                    }
                }
            }
        }
        return max;
    }

    private static List<Character> getTheMostPopularInitial(Map<Character , List<FirstName>> characterListMap){
        List<Character> theMostPopularInitial = new ArrayList<>();
        int counter = findMaxChar();

        for (Character key : characterListMap.keySet()) {
            if(characterListMap.get(key).size() == counter){
                theMostPopularInitial.add(key);
            }
        }
        return theMostPopularInitial;
    }

    public static int runSeventh() {
        String character = "e";
        int num;
        num = countTheNamesStartingWith(firstNamesMap, character);
        return num;
    }

    private static int countTheNamesStartingWith(Map<Gender, List<FirstName>> firstNamesMap, String character) {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (character.toUpperCase().equals(String.valueOf(firstName.getFirstName().charAt(0)))) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList.size();
    }

    public static void runEighth() {
        String rate = rateOfManWomanNamesByGender();
        System.out.println(rate);
    }

    private static String rateOfManWomanNamesByGender() {
        float rateOfMale = rateOfMaleNames();
        // float rateOfFemale = 100 - rateOfMale;
        int rateMale = (int) rateOfMale;
        int rateOfFem = 100 - rateMale;

        return (rateMale + " : " + rateOfFem);
    }

    private static float rateOfMaleNames() {
        float sum = sumNames();
        float sumMale = sumMaleNames();
        return (sumMale / sum) * 100;
    }

    private static int sumNames() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (Gender.MALE.equals(firstName.getGender()) || Gender.FEMALE.equals(firstName.getGender())) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList.size();
    }

    private static int sumMaleNames() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (Gender.MALE.equals(firstName.getGender())) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList.size(); // == counter!!!
    }

    public static List<String> runNinth() {
        return findMaxMeaningOfNames();
    }

    private static List<String> findMaxMeaningOfNames() {
        int max = findMaxMeaning();
        List<String> firstNameHasMoreMeaning = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (max == firstName.getMeaning().size()) {
                    firstNameHasMoreMeaning.add(firstName.getFirstName());
                }
            }
        }
        return firstNameHasMoreMeaning;
    }

    private static int findMaxMeaning() {
        int max = 0;

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getMeaning().size() > max) {
                    max = firstName.getMeaning().size();
                }
            }
        }
        return max;
    }

    public static List<String> runTenth() {
        return findNamesMeaningIsUnknownMale();
    }

    public static List<String> runEleventh() {
        return findNamesMeaningIsUnknownFemale();
    }

    private static List<String> findNamesMeaningIsUnknownMale() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(Gender.MALE) && firstName.getMeaning().get(0).contains("ismeretlen")) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList;
    }

    private static List<String> findNamesMeaningIsUnknownFemale() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(Gender.FEMALE) && firstName.getMeaning().get(0).contains("ismeretlen")) {
                        tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList;
    }

    public static List<FirstName> runThirteenthB() {
        return checkLastChar(Gender.MALE, 'a');
    }

    public static int runThirteenthA() {
        return checkLastChar(Gender.MALE, 'a').size();
    }

    private static  List<FirstName> checkLastChar(Gender gender, Character character) {
        List<FirstName> tempList = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(gender) && character.equals(firstName.getFirstName().charAt(firstName.getFirstName().length()-1))) {
                    tempList.add(firstName);
                }
            }
        }
        return tempList;
    }

    public static List<FirstName> runTwelfthB() {
        return checkLastCharNot(Gender.FEMALE, 'a');
    }

    public static int runTwelfthA() {
        return checkLastCharNot(Gender.FEMALE, 'a').size();
    }

    private static  List<FirstName> checkLastCharNot(Gender gender, Character character) {
        List<FirstName> tempList = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(gender) && character != firstName.getFirstName().charAt(firstName.getFirstName().length()-1)) {
                    tempList.add(firstName);
                }
            }
        }
        return tempList;
    }

    public static List<String> runFourteenth() {
        return findNameByParts("Anna");
    }

    private static List<String> findNameByParts(String part) {
        List<String> nameList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getFirstName().toUpperCase().contains(part.toUpperCase())) {
                    nameList.add(firstName.getFirstName());
                }
            }
        }
        return nameList;
    }

    public static Set<FirstName> runFifteenth() {
        return searchingInTheMeaning("kő");
    }

    private static Set<FirstName> searchingInTheMeaning(String part) {
        Set<FirstName> nameSet = new HashSet<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (int i = 0; i < firstNamesMap.size(); i++) {
                for (FirstName firstName : firstNameList) {
                    if (iterateOnList(firstName.getMeaning(), part)) {
                        Collections.swap(firstName.getMeaning(), findIndex(firstName.getMeaning(), part), 0);
                        nameSet.add(firstName);
                    }
                }
            }
        }
        return nameSet;
    }

    private static boolean iterateOnList(List<String> stringList, String s) {
        for (String string : stringList) {
            if (string.toUpperCase().contains(s.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    private static int findIndex(List<String> stringList, String s) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).contains(s)) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> runSixteenth() {
        return findNameByGenderAndFirstLetter(Gender.FEMALE, 'e');
    }

    private static List<String> findNameByGenderAndFirstLetter(Gender gender, Character character) {
        List<String> stringList = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(gender) && firstName.getFirstName().charAt(0) == Character.toUpperCase(character)) {
                    stringList.add(firstName.getFirstName());
                }
            }
        }
        return stringList;
    }

    public static Set<String> runSeventeenth() {
        return findNamesByOrigin("héber");
    }

    private static Set<String> findNamesByOrigin(String origin) {
        Set<String> tempList = new HashSet<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (findByOrigin(firstName.getOrigin(), origin)) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList;
    }

    private static boolean findByOrigin(List<String> stringList, String origin) {
        for (String s : stringList) {
            if (s.equals(origin)) {
                return true;
            }
        }
        return false;
    }

    public static Set<String> runSeventeenthExtra() {
        return findByArgs(ARGS);
    }

    public static boolean verifyAllElementsAreEqual(List<String> list, Object[] args) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < args.length; j++) {
                if (list.get(i).equals(args[j])) {
                    stringList.add(list.get(i));
                }
                if (stringList.size() == args.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Set<String> findByArgs(Object[] args) {
        Set<String> stringSet = new HashSet<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (verifyAllElementsAreEqual(firstName.getOrigin(), ARGS)) {
                    stringSet.add(firstName.getFirstName());
                }
            }
        }
        return stringSet;
    }

    public static List<String> runSeventeenthExtraBonus(){
        return findAnyFits(ARGS_2);
    }

    private static boolean verifyAnyArgs(List<String> stringList, Object[] args) {
        for (Object arg : args) {
            for (String s : stringList) {
                if (arg.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<String> findAnyFits(Object[] args) {
        List<String> stringList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (verifyAllElementsAreEqual(firstName.getOrigin(), ARGS_2)) {
                    stringList.add(0, firstName.getFirstName());
                } else if (verifyAnyArgs(firstName.getOrigin(), ARGS_2) && ! stringList.contains(firstName.getFirstName())) {
                    stringList.add((firstName.getFirstName()));
                }
            }
        }
        return stringList;
    }
}