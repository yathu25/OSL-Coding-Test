package checkoutSystem;


import Models.Product;
import Models.ProductTypes;

import java.math.BigDecimal;
import java.util.List;

public class DiscountOnBulk implements PricingRule {

    private ProductTypes sku;
    private int quantity;
    private BigDecimal discountPrice;

    public DiscountOnBulk(ProductTypes pt, int quantity, BigDecimal discountPrice) {
        sku = pt;
        this.quantity = quantity;
        this.discountPrice = discountPrice;
    }

    @Override
    public void applySpecificRule(Basket basket) {
        List<Product> products = basket.getByProductType(sku);
        if (products.size() > quantity) {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                product.changePrice(discountPrice);
            }
        }
    }
}
