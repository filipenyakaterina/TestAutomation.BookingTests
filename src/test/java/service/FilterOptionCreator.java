package service;

import exceptions.NoSuchFilterOptionException;
import model.DataValueProviding;

import java.util.EnumSet;
import java.util.Optional;

public class FilterOptionCreator {
    public static <T extends Enum & DataValueProviding> T getFilterOptionFromDataValue(Class<T> filterOptionsClass, String dataValue) throws NoSuchFilterOptionException {
        Optional<T> resultOption = EnumSet.allOf(filterOptionsClass).stream().filter(filterOption ->
                ((T) filterOption).getDataValue() == Integer.parseInt(dataValue)).findFirst();
        if (resultOption.isPresent())
            return resultOption.get();
        else throw new NoSuchFilterOptionException("Filter option with data value " + dataValue + " is absent.");
    }
}
