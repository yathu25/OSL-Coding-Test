package Models;

import java.math.BigDecimal;
import java.util.Objects;


public class Product {
	 private ProductTypes productType ;
	    private BigDecimal price;

	    public Product(ProductTypes sku, BigDecimal price) {
	        this.productType = sku;
	        this.price = price;
	    }

	    public ProductTypes getSku() {
	        return productType;
	    }

	    public String getName() {
	        return productType.getName();
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }


	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Product product = (Product) o;
	        return getSku() == product.getSku();
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getSku());
	    }

	    public void changePrice(BigDecimal newPrice) {
	        this.price = newPrice;
	    }
}
