package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Counter {
    private WebElement counter;
    private WebElement value;
    private WebElement plusButton;
    private WebElement minusButton;

    public Counter(WebElement counterAria) {
        counter = counterAria;
        value = counter.findElement(By.xpath(".//span[@data-bui-ref = 'input-stepper-value']"));
        plusButton = counter.findElement(By.xpath(".//button[@data-bui-ref = 'input-stepper-add-button']"));
        minusButton = counter.findElement(By.xpath(".//button[@data-bui-ref = 'input-stepper-subtract-button']"));
    }

    public void setCount(int count) {
        int currentCount = Integer.parseInt(value.getText());
        if (count > currentCount) {
            for (int i = 0; i < (count - currentCount); i++) {
                plusButton.click();
            }
        } else if (count < currentCount) {
            for (int i = 0; i < (currentCount - count); i++) {
                minusButton.click();
            }
        }
    }
}
