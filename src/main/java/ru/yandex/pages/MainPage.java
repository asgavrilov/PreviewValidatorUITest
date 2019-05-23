package ru.yandex.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private static final String URL = "http://video.yandex.ru";
    private static final int TIMEOUT = 30000;


    private SelenideElement SearchInput = $("input[type='search']");
    private SelenideElement MoreButton = $("button.more__button");

    public MainPage goToMainPage() {
        open(URL);
        return this;
    }

    public MainPage inputValue(String value) {
        //   MoreButton.should(Condition.visible);
        SearchInput.clear();
        SearchInput.sendKeys(value);

        return page(MainPage.class);
    }


    public VideoResultsPage submit() {

        SearchInput.submit();


        return page(VideoResultsPage.class);
    }
}
