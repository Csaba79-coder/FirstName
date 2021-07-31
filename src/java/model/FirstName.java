package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstName {

    private String firstName;
    private Gender gender;
    private List<String> origin;
    private List<String> meaning;
    private final String SEPARATOR = ", ";

    public FirstName(String[] parts) {
        this(parts[0], parts[1], parts[2], parts[3]);
    }

    public FirstName(String firstName, String gender, String origin, String meaning) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.gender = Gender.valueOf(gender);
        this.origin = Arrays.asList(origin.split("-"));
        this.meaning = Arrays.asList(meaning.split(","));
    }

    @Override
    public String toString() {
        return ("\nName: " + this.getFirstName() +
                "\n\tGender: " + this.getGender().getHUN_NAME() +
                "\n\tOrigin: " + getString(createUnknown(this.origin), SEPARATOR)) +
                "\n\tMeaning: " + getString(createList(this.meaning, "(ismeretlen)"), SEPARATOR);
    }

    private String getString(List<String> list, String separator) {
        StringBuilder b = new StringBuilder();
        for (String s : list) {
            b.append(s).append(separator);
        }
        b.setLength(b.length() - separator.length());
        return b.toString();
    }

    private List<String> createList(List<String> stringList, String sForChange) {
        List<String> tempList = new ArrayList<>();
        for (String s : stringList) {
            if (s.equals(sForChange)) {
                String newString = s.substring(1, s.length() - 1);
                tempList.add(newString);
                return tempList;
            }
        }
        return stringList;
    }

    private List<String> createUnknown(List<String> stringList) {
        List<String> s = new ArrayList<>();
        if (stringList.contains("NULL")) {
            s.add("ismeretlen");
            return s;
        }
        return stringList;
    }

    private String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<String> getOrigin() {
        return origin;
    }

    public void setOrigin(List<String> origin) {
        this.origin = origin;
    }

    public List<String> getMeaning() {
        return meaning;
    }

    public void setMeaning(List<String> meaning) {
        this.meaning = meaning;
    }
}
