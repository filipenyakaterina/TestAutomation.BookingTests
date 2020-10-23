package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.Executor;
import service.Waiter;
import utils.TestLogger;

public class BookingHomePage extends AbstractPage {
    public static final String HOMEPAGE_URL = "https://www.booking.com/";

    private By languageOptionLocator;

    public BookingHomePage(WebDriver driver) {
        super(driver);
    }

    public BookingHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        TestLogger.writeMessage("Page " + HOMEPAGE_URL + " is opened");
        return this;
    }

    public BookingSearchPage selectLanguage(String languageKey) {
        By languagesLinkLocator = By.xpath("//li[@data-id = 'language_selector']/a");
        By languagesButtonLocator = By.xpath("//button[contains(@data-modal-id,'language-selection')]");

        languageOptionLocator = By.xpath("//a[@hreflang = '" + languageKey + "']");
        if (!driver.findElements(languagesLinkLocator).isEmpty()) {
            selectLanguageWithLink(languagesLinkLocator);
        } else if (!driver.findElements(languagesButtonLocator).isEmpty()) {
            selectLanguageWithButton(languagesButtonLocator);
        }
        TestLogger.writeMessage("English(US) language was selected");
        return new BookingSearchPage(driver);
    }

    private void selectLanguageWithLink(By linkLocator) {
        WebElement languagesLink = driver.findElement(linkLocator);
        Waiter.expandElementAndWait(languagesLink);
        selectLanguageOption(languageOptionLocator);
        Waiter.waitUntilElementWillBeClickable(linkLocator);
        Waiter.waitUntilElementNotBeExpanded(linkLocator);
    }

    private void selectLanguageWithButton(By buttonLocator) {
        WebElement languagesButton = driver.findElement(buttonLocator);
        Executor.clickElementWithJS(languagesButton);
        selectLanguageOption(languageOptionLocator);
        Waiter.waitUntilElementNotBeHidden(By.tagName("body"));
    }

    private void selectLanguageOption(By optionLocator) {
        WebElement languageOption = driver.findElement(optionLocator);
        Executor.clickElementWithJS(languageOption);
    }
}
