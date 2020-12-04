package service;

import java.util.List;
import java.util.function.BiPredicate;

public class Conditions {
    public static boolean checkIfListSortedByDescending(List<Integer> verifiableList) {
        return checkIfListSortedBy(verifiableList, (element, previousElement) -> element > previousElement);
    }

    public static boolean checkIfListSortedByAscending(List<Integer> verifiableList) {
        return checkIfListSortedBy(verifiableList, (element, previousElement) -> element < previousElement);
    }

    private static boolean checkIfListSortedBy(List<Integer> verifiableList, BiPredicate<Integer, Integer> sortConditions) {
        for (int i = 1; i < verifiableList.size(); i++) {
            if (sortConditions.test(verifiableList.get(i), verifiableList.get(i - 1)))
                return false;
        }
        return true;
    }

    public static boolean checkIfListConsistsOfNumbersInRange(List<Integer> listOfNumbers, int minNumber, int maxNumber) {
        return listOfNumbers.stream().noneMatch(listMember -> (listMember < minNumber) || (listMember > maxNumber));
    }

    public static boolean checkIfListNotContainNumberLessThen(List<Double> listOfNumbers, int minNumber) {
        return listOfNumbers.stream().noneMatch(listMember -> listMember < minNumber);
    }
}
