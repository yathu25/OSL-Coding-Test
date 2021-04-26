package checkoutSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Models.Product;
import Models.ProductTypes;

public class Basket {
	private List<Product> basketItems = new ArrayList<>();

    public void addCartItem(Product product ) {
        basketItems.add(product);
    }

    public List<Product> getByProductType(ProductTypes pr) {
        List<Product> similarItems = new ArrayList<>();
        for (Product product : this.basketItems) {
            if (product.getSku().equals(pr)) {
                similarItems.add(product);
            }
        }
        return similarItems;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Product item : this.basketItems) {
            total = total.add(item.getPrice());
        }
        return total;
    }
}
