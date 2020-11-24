package page;

import org.openqa.selenium.WebDriver;
import page_elements.CurrencyOption;
import page_elements.LanguageOption;
import utils.TestLogger;

public class BookingHomePage extends AbstractPage {
    public static final String HOMEPAGE_URL = "https://www.booking.com/";

    public BookingHomePage(WebDriver driver) {
        super(driver);
    }

    public BookingHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        TestLogger.writeMessage("Page " + HOMEPAGE_URL + " is opened");
        return this;
    }

    public BookingHomePage selectLanguage(String languageCode) {
        LanguageOption language = new LanguageOption(driver);
        language.select(languageCode);
        TestLogger.writeMessage("Language with code " + languageCode + " was selected");
        return this;
    }

    public BookingHomePage selectCurrency(String currencyCode) {
        CurrencyOption currency = new CurrencyOption(driver);
        currency.select(currencyCode);
        TestLogger.writeMessage("Currency with code " + currencyCode + " was selected");
        return this;
    }

    public BookingSearchPage searchBooking() {
        return new BookingSearchPage(driver);
    }
}
