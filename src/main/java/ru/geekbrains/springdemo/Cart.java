package ru.geekbrains.springdemo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)

public class Cart {
    private List<Product> productList;

    public Cart() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void delProduct(int id) {
        productList.removeIf(product -> product.getId() == id);
    }
}
