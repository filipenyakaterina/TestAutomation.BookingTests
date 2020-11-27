package page_elements;

import org.openqa.selenium.WebElement;
import service.Executor;

public class BudgetHandler {
    private static final int HANDLER_LENGTH = 214;
    private static final int HANDLER_BUDGET_STEP = 5;
    private static final int SIGN_MOVE_FROM_RIGHT_TO_LEFT = -1;

    private WebElement lowerHandler;
    private WebElement upperHandler;
    private double minHandlerValue;
    private double maxHandlerValue;
    private double step;

    public BudgetHandler(WebElement lowerHandler, WebElement upperHandler) {
        this.lowerHandler = lowerHandler;
        this.upperHandler = upperHandler;
        minHandlerValue = Double.valueOf(lowerHandler.getAttribute("aria-valuemin"));
        maxHandlerValue = Double.valueOf(upperHandler.getAttribute("aria-valuemax"));
        step = (HANDLER_LENGTH / (maxHandlerValue - minHandlerValue)) * HANDLER_BUDGET_STEP;
    }

    public void setRange(int minBudgetValue, int maxBudgetValue){
        int offset, stepsCount;

        stepsCount = (minBudgetValue - (int) minHandlerValue) / HANDLER_BUDGET_STEP;
        offset = (int) (step * stepsCount);
        System.out.println(stepsCount);
        System.out.println(offset);
        setHandlerValue(lowerHandler, offset);
        stepsCount = ((int) maxHandlerValue - maxBudgetValue) / HANDLER_BUDGET_STEP;
        offset = (int) (SIGN_MOVE_FROM_RIGHT_TO_LEFT * step * stepsCount);
        System.out.println(stepsCount);
        System.out.println(offset);
        setHandlerValue(upperHandler, offset);
    }

    private void setHandlerValue(WebElement handler, int offset){
        Executor.scrollToElement(handler);
        Executor.dragAndDropElementHorizontally(handler, offset);
        System.out.println(handler.getAttribute("aria-valuenow"));
        System.out.println(handler.getAttribute("aria-valuetext"));
    }
}
