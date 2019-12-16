package org.team68.model;

import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class GamePage implements Page {
    //    public static final String INNER_TEXT = "innerText";
    public static final String CONFIRM_PURCHASE_BUTTON = "//div[@class='confirm-container row']/div/button";
    public static final String ACCEPT_REFUND_BUTTON = "//div[@class='overlay-btn-row']/button[2]";
    public static final String TITLE = "//title[1]";
    public static final String OBTAIN_SPAN = "//span[text()='Obtenir']";
    public static final String OWNED_SPAN = "//span[text()='Possédé']";
    public static final String PEGI_SPAN = "//span[text()='Continuer']";

    private String url;
    private String title;

    public boolean isAlreadyOwned() {
        return $x(OWNED_SPAN).parent().exists();
    }

    public String getTitle() {
        return TITLE;
    }


    public GamePage pegi() throws InterruptedException {
        Thread.sleep(4000);
        if ($x(PEGI_SPAN).exists()) {
            $x(PEGI_SPAN).click();
        }
        return this;
    }

    public GamePage purchase() throws InterruptedException {
        Thread.sleep(4000);
        $x(OBTAIN_SPAN).parent().click();
        return this;
    }

    public GamePage confirmPurchase() throws InterruptedException {
        Thread.sleep(4000);
        $x(CONFIRM_PURCHASE_BUTTON).click();
        return this;
    }

    public GamePage acceptRefund() throws InterruptedException {
        Thread.sleep(4000);
        if ($x(ACCEPT_REFUND_BUTTON).exists()) {
            $x(ACCEPT_REFUND_BUTTON).click();
        }
        return this;
    }

    @Override
    public Page open() {
        return null;
    }
}
