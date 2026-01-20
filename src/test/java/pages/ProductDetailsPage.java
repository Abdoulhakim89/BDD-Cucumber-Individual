package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    private By addToCartButton = By.name("add-to-cart");
    private By viewCartButton = By.cssSelector(".woocommerce-message>.button");
    private By qtyField = By.className("qty");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(){
        driver.findElement(addToCartButton).click();
    }

    public void viewCart(){
        driver.findElement(viewCartButton).click();
    }
    public void addProductToCart(int qty){
        var qtyFieldElement = driver.findElement(qtyField);
        qtyFieldElement.sendKeys(Keys.CONTROL + "A"+Keys.BACK_SPACE);
        qtyFieldElement.sendKeys(String.valueOf(qty));
        driver.findElement(addToCartButton).click();
    }
}
