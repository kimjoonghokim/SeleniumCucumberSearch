package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchPage {
    WebDriver driver;

    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By results = By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.s-wide-grid-style.sg-row");
    By noResultsMessage = By.className("s-no-outline");
    By suggestions = By.cssSelector("#nav-flyout-searchAjax > div.autocomplete-results-container > div > div.left-pane-results-container > div:nth-child(1) > div > div.s-suggestion.s-suggestion-ellipsis-direction");
    By nextPage = By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.s-wide-grid-style.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span.rush-component.s-latency-cf-section > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(74) > div > div > span > a:nth-child(4)");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String term) {
        driver.findElement(searchBox).sendKeys(term);
        driver.findElement(searchButton).click();
    }

    public boolean isResultRelatedTo(String term) {
        for (WebElement result : driver.findElements(results)) {
            if (result.getText().toLowerCase().contains(term.toLowerCase())) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    public boolean isNoResultDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(noResultsMessage).isDisplayed();
    }

    public void typeInSearchBox(String term) {
        driver.findElement(searchBox).sendKeys(term);
    }

    public boolean areSuggestionsRelatedTo(String term) {
        assert driver.findElement(suggestions).isDisplayed();
        return driver.findElement(suggestions).getText().contains(term);
    }

    public void goToNextPage() {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(nextPage));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(nextPage).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.CSS_SELECTOR, "a[id^='button-'] > span.x-btn-wrap > span.x-btn-button > span.x-btn-inner.x-btn-inner-center"))).click()
    }
}
