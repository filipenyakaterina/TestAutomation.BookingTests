package test;

import model.Instance;
import org.testng.annotations.Test;
import page.BookingHomePage;
import service.InstanceCreator;


public class FilterTests extends CommonConditions {
    @Test(description = "Check filter by price on Search Results page")
    public void checkFilterByPrice() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        new BookingHomePage(driver).openPage().selectCurrency(CURRENCY_CODE).selectLanguage(LANGUAGE_CODE).searchBooking().
                enterSearchData(testInstance.getDeparture(), testInstance.getCheckInDate(), testInstance.getCheckOutDate(),
                        testInstance.getAdultsCount(), testInstance.getChildrenCount(), testInstance.getRoomsCount()).
                getFilterBox().filterByOwnBudget(65,135);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
