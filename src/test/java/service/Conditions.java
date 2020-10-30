package service;

import java.util.List;

public class Conditions {
    public static boolean checkIfListSortedByAscending(List<Integer> verifiableList) {
        for (int i = 1; i < verifiableList.size(); i++) {
            if (verifiableList.get(i) < verifiableList.get(i - 1))
                return false;
        }
        return true;
    }
}
