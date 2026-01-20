package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static CartPage cartPage;
    private static StorePage storePage;
    private static CheckoutPage checkoutPage;
    private static ProductDetailsPage productDetailsPage;

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null?new CartPage(driver):cartPage;
    }

    public static StorePage getStorePage(WebDriver driver) {
        return cartPage == null?new StorePage(driver):storePage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver) {
        return cartPage == null?new CheckoutPage(driver):checkoutPage;
    }

    public static ProductDetailsPage getProductDetailsPage(WebDriver driver) {
        return cartPage == null?new ProductDetailsPage(driver):productDetailsPage;
    }
}
