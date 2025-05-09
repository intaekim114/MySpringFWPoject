package mylab.order.di.xml;
import java.util.List;

public class ShoppingCart {
	private List<Product> products;
	
	public ShoppingCart() {}

	public List<Product> getProducts() { return products; }

	public void setProducts(List<Product> products) { this.products = products; }
	
	public double getTotalPrice() {
		if (products == null || products.isEmpty()) {
            return 0;
		}
		
        double total = 0;
        for (Product product : products) {
                total += product.getPrice();
        }
        return total ;
	}
	
}
