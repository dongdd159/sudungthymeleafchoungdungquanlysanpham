package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> customers;

    static {

        customers = new HashMap<>();
        customers.put(1, new Product(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Product(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Product(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Product(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Product(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Product(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Product customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Product findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Product customer) {
        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

    @Override
    public Product search(String name) {
        for (Product product: findAll()) {
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
}
