package ru.yandex.video.steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import ru.yandex.pages.MainPage;
import ru.yandex.pages.VideoResultsPage;

public class MyStepdefs {

    private MainPage mainPage = new MainPage();
    private VideoResultsPage videoResultsPage = new VideoResultsPage();


    private SoftAssertions softAssertions;


    @Given("^open video\\.yandex\\.ru$")
    public void openVideoYaPage() throws Throwable {

        mainPage.goToMainPage();

    }

    @When("^type \"([^\"]*)\" value and submit Find button$")
    public void typeValue(String value) {
        mainPage.inputValue(value);
        mainPage.submit();
    }

    @And("^(\\d+) items are displayed$")
    public void itemResults(int Quantity) {
        videoResultsPage.scrollToBottom(WebDriverRunner.getWebDriver());
        Assert.assertEquals(Quantity, videoResultsPage.results(WebDriverRunner.getWebDriver()).size());
    }

    @And("^go through the items with mouse over action and make two screenshots$")
    public void mouseAllItemsOver() throws Throwable {
        videoResultsPage.mouseElementOver(WebDriverRunner.getWebDriver(), videoResultsPage.results(WebDriverRunner.getWebDriver()));
    }

    @Then("^compare screenshots")
    public void compareScreenshots() {
        softAssertions = new SoftAssertions();
        for (int i = 0; i < videoResultsPage.results(WebDriverRunner.getWebDriver()).size(); i++) {


//            softAssertions.assertThat(videoResultsPage.isPreviewForItemExist("test-result/screenshots/before" + i + ".png","test-result/screenshots/after" + i + ".png")).hasToString("1");
            videoResultsPage.isPreviewForItemExist("test-result/screenshots/before" + i + ".png", "test-result/screenshots/after" + i + ".png");
            softAssertions.assertAll();

        }

    }


}
