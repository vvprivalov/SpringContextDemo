package ru.geekbrains.springdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getProductById(int id) {
        return productList.stream().filter(product -> product.getId() == id)
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Product product: productList) {
            str.append("Продукт [ Номер = " + product.getId() + " Наименование = " + product.getName() + " Цена = " +
                    product.getPrice() + " ]" + "\n");
        }
        return str.toString();
    }
}
