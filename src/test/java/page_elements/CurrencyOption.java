package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrencyOption extends UserOption {
    public CurrencyOption(WebDriver driver) {
        super(driver);
        linkLocator = By.xpath("//li[@data-id = 'currency_selector']/a");
        buttonLocator = By.xpath("//button[@data-modal-header-async-type='currencyDesktop']");
    }

    public void select(String code) {
        optionLocator = By.xpath("//a[contains(@href, '" + code + "')]");
        selectLocator();
    }
}
