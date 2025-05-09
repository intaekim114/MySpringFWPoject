package mylab.order.di.xml;

public class OrderService {
	private ShoppingCart shoppingCart;
	
	public OrderService() {}
	
	// Getters and Setters
	public ShoppingCart getShoppingCart() { return shoppingCart; }
	public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }

	public double calculateOrderTotal() {
		return shoppingCart.getTotalPrice();
	}
	
	
}