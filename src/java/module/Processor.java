package module;

import model.FirstName;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static controller.FirstNameController.*;
import static util.PrintingFormat.*;


public class Processor {

    public static void run() {

        try {

            runFirstSecondThird();

        } catch (IOException e) {
            e.printStackTrace();
        }

        runFourth();
        printSeparation();
        runFifth();
        printSeparation();
        List<Character> characterList = runSixth();
        printArrayToChar(characterList);
        printSeparation();
        int specChar = runSeventh();
        System.out.println(specChar);
        printSeparation();
        runEighth();
        printSeparation();
        List<String> namesHasMostMeaning = runNinth();
        printArrayToString(namesHasMostMeaning);
        printSeparation();
        List<String> manMeaningIsUnknown = runTenth();
        printArrayToString(manMeaningIsUnknown);
        printSeparation();
        List<String> womanMeaningIsUnknown = runEleventh();
        printArrayToString(womanMeaningIsUnknown);
        printSeparation();
        int findLastCharNotSize = runTwelfthA();
        System.out.println(findLastCharNotSize);
        List<FirstName> findLastCharNot = runTwelfthB();
        printArrayToStringFirstName(findLastCharNot);
        printSeparation();
        int findLastCharSize = runThirteenthA();
        System.out.println(findLastCharSize);
        List<FirstName> findLastChar = runThirteenthB();
        printArrayToStringFirstName(findLastChar);
        printSeparation();
        List<String> findNameByParts = runFourteenth();
        printArrayToString(findNameByParts);
        printSeparation();
        Set<FirstName> searchingInTheMeaning = runFifteenth();
        printSetFirstName(searchingInTheMeaning);
        printSeparation();
        List<String> findNameByGenderAndFirstLetter = runSixteenth();
        printArrayToString(findNameByGenderAndFirstLetter);
        printSeparation();
        Set<String> findNamesByOrigin = runSeventeenth();
        printSet(findNamesByOrigin);
        printSeparation();
        System.out.println("All origin: ");
        Set<String> findByAllArgsMeaning = runSeventeenthExtra();
        printSet(findByAllArgsMeaning);
        printSeparation();
        System.out.println("All origin, even if includes any of the origins (first ones have the most origin!): ");
        List<String> findAnyFits = runSeventeenthExtraBonus();
        printArrayToString(findAnyFits);
    }
}
