package steps;

import factory.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductDetailsPage;

public class addFromProductDetailsStepDefs {
    private WebDriver driver;
    private ProductDetailsPage productDetails;

    @Given("customer is on the {string} details page")
    public void customerIsOnTheProductDetailsPage(String product) {
        driver = DriverFactory.getDriver();
        productDetails = new ProductDetailsPage(driver);
        productDetails.load("https://askomdch.com/product/"+product);
    }


    @When("customer adds 1 {string} to cart")
    public void customerAddsToCart(String arg1) {
        productDetails.addProductToCart();

    }
    @Then("customer should see {int} {string} to cart")
    public void customerSeeProductInCart(){

    }
}
