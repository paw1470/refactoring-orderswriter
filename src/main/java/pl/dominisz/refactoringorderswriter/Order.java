package pl.dominisz.refactoringorderswriter;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
