package pages;

import org.openqa.selenium.By;

public class DetailsPage {

    private By inStock = By.xpath("//div[@class='inventory']");
    private By addToCart = By.xpath("//button[@class='add-button' and contains(text(),'Add to cart') or contains(text(),'Out Of Stock') ]");
    private By cartItem = By.xpath("//a[@href='#/cart']");

    public By getInStock() {
        return inStock;
    }

    public void setInStock(By inStock) {
        this.inStock = inStock;
    }

    public By getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(By addToCart) {
        this.addToCart = addToCart;
    }

    public By getCartItem() {
        return cartItem;
    }
}
