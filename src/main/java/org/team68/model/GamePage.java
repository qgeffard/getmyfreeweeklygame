package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class GamePage implements Page {
//    public static final String INNER_TEXT = "innerText";
    public static final String CONFIRM_PURCHASE_BUTTON = "//div[@class='confirm-container row']/div/button";
    public static final String ACCEPT_REFUND_BUTTON = "//div[@class='overlay-btn-row']/button[2]";
    public static final String TITLE = "//title[1]";
    public static final String OBTAIN_SPAN = "//span[text()='Obtenir']";
    public static final String OWNED_SPAN = "//span[text()='Possédé']";

    private String url;
    private String title;

    public boolean isAlreadyOwned() {
        return $x(OWNED_SPAN).parent().exists();
    }

    public String getTitle() {
        return TITLE;
    }

    public GamePage purchase() throws InterruptedException {
        $x(OBTAIN_SPAN).parent().click();
        Thread.sleep(5000);
        return this;
    }

    public GamePage confirmPurchase() throws InterruptedException {
        $x(CONFIRM_PURCHASE_BUTTON).click();
        Thread.sleep(5000);
        return this;
    }

    public GamePage acceptRefund() {
        $x(ACCEPT_REFUND_BUTTON).click();
        return this;
    }

    @Override
    public Page open() {
        return null;
    }
}
