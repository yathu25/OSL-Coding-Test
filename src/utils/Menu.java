package utils;

import java.util.HashMap;
import java.util.Map;

import Models.Product;
import Models.ProductTypes;


public class Menu {
	private Map<ProductTypes, Product> products = new HashMap<>();

    public Product newItem(ProductTypes productType) {
        Product item = products.get(productType);
        return new Product(item.getSku(), item.getPrice());
    }

    public void addProduct(Product item) {
        products.put(item.getSku(), item);
    }
}
