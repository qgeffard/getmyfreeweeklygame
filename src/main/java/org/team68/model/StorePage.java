package org.team68.model;

import com.codeborne.selenide.Selenide;
import org.team68.workflow.Page;

import static com.codeborne.selenide.Selenide.$x;

public class StorePage implements Page {
    public static final String URL = "https://www.epicgames.com/store/fr";
    public static final String CLOSE_COOKIES_BUTTON = "//button[@id='euCookieAccept']";
    public static final String CURRENT_FREE_GAME = "//span[text()='Gratuit maintenant']";

    public StorePage open() {
        Selenide.open(URL);
        return this;
    }
}
