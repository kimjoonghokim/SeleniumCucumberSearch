package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.SearchPage;
import static org.junit.Assert.*;
import org.openqa.selenium.JavascriptExecutor;

public class SearchSteps {
    WebDriver driver;
    SearchPage searchPage;

    @Given("I am on the search page")
    public void i_am_on_the_search_page() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.ca");
        searchPage = new SearchPage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String term) {
        searchPage.search(term);
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String term) {
        assertTrue(searchPage.isResultRelatedTo(term));

    }

    @Then("I should see no results")
    public void i_should_see_no_results() {
        assertTrue(searchPage.isNoResultDisplayed());


    }

    @When("I type {string} in the search box")
    public void i_type_in_the_search_box(String term) {
        searchPage.typeInSearchBox(term);
    }

    @Then("I should see search suggestions related to {string}")
    public void i_should_see_search_suggestions_related_to(String term) {
        assertTrue(searchPage.areSuggestionsRelatedTo(term));

    }

    @When("I navigate to the second page of search results")
    public void i_navigate_to_the_second_page_of_search_results() {
        searchPage.goToNextPage();
    }

    @Then("I should see results related to {string} on the second page")
    public void i_should_see_results_related_to_on_the_second_page(String term) {
        assertTrue(searchPage.isResultRelatedTo(term));

    }

    @Then("I close the search page")
    public void i_close_the_search_page() {
        driver.close();
        driver.quit();
    }
}
