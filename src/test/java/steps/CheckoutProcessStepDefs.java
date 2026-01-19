package steps;

import domainObjects.BillingDetailsObject;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.StorePage;

public class CheckoutProcessStepDefs {
    private WebDriver driver;
    private StorePage storePage;
    private CheckoutPage checkoutPage;
    private BillingDetailsObject billingDetails;


        @Given("the customer has a product in the cart")
        public void customerHasProductInCart (){
            driver = DriverFactory.setUpDriver();
            storePage = new StorePage(driver);
            storePage.load("https://askomdch.com/store/");
            storePage.addProductToCart("Basic Blue Jeans");
            storePage.addProductToCart("Dark Brown Jeans");
            storePage.addProductToCart("Blue Tshirt");

        }

        @And("the guest customer is on the checkout page")
        public void guestCustomerIsOnCheckoutPage (){
            var cart = storePage.viewCartPage();
            cart.proceedToCheckout();
        }

        @And("the customer's billing details are")
        public void customerBillingDetails (BillingDetailsObject billingDetails){
            this.billingDetails = billingDetails;
        }


        @When("the customer completes the billing details stage")
        public void guestCustomerCompletesBillingDetailsStage (){
            checkoutPage = new CheckoutPage(driver);
            checkoutPage.fillBillingForm(billingDetails);
            checkoutPage.placeOrder();
        }

        @Then("the order should be placed successfully")
        public void orderIsPlacedSuccessfully (){

        }
}
