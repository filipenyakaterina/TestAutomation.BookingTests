package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguageOption extends UserOption {
    public LanguageOption(WebDriver driver) {
        super(driver);
        linkLocator = By.xpath("//li[@data-id = 'language_selector']/a");
        buttonLocator = By.xpath("//button[contains(@data-modal-id,'language-selection')]");
    }

    public void select(String code) {
        optionLocator = By.xpath("//a[@hreflang = '" + code + "']");
        selectLocator();
    }
}
