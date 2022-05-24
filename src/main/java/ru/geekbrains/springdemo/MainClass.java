package ru.geekbrains.springdemo;

import Config.AppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        productRepository.addProduct(new Product(1, "Молоко", 2.5));
        productRepository.addProduct(new Product(2, "Сыр", 5.2));
        productRepository.addProduct(new Product(3, "Хлеб", 0.8));
        productRepository.addProduct(new Product(4, "Мясо", 8.9));
        productRepository.addProduct(new Product(5, "Овощи", 4.3));


        // Формируем информационный текст
        System.out.println("Содержимое вашего репозитория");
        System.out.println(productRepository);
    }
}
