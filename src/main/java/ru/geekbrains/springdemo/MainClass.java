package ru.geekbrains.springdemo;

import Config.AppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String request = new String("");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        productRepository.addProduct(new Product(1, "Молоко", 2.5));
        productRepository.addProduct(new Product(2, "Сыр", 5.2));
        productRepository.addProduct(new Product(3, "Хлеб", 0.8));
        productRepository.addProduct(new Product(4, "Мясо", 8.9));
        productRepository.addProduct(new Product(5, "Овощи", 4.3));

        Cart cart = context.getBean("cart", Cart.class);

        // Формируем информационный текст
        System.out.println("Содержимое вашего репозитория");
        System.out.println(productRepository + "\n");
        System.out.println("Содержимое вашей корзины");
        System.out.println(cart + "\n");
        System.out.println("Основные команды для работы с корзиной:");
        System.out.println("/end - завершение работы");
        System.out.println("/new  - запрос новой корзины");
        System.out.println("/add-[id]  - добавление продукта по Id из репозитория в корзину");
        System.out.println("/del-[id]  - удаление продукта из корзины по Id");


        while (true) {
            request = scanner.nextLine();

            if (request.trim().equals("/end")) {
                break;
            }

            if (request.trim().startsWith("/new")) {
                cart = context.getBean("cart", Cart.class);
                System.out.println("Взята новая корзина");
            }

            if (request.trim().startsWith("/del")) {
                cart.delProduct(Integer.parseInt(request.substring(5)));
                System.out.println("Содержимое вашей корзины");
                System.out.println(cart + "\n");
            }

            if (request.trim().startsWith("/add")) {
                cart.addProduct(productRepository.getProductById(Integer.parseInt(request.substring(5))));
                System.out.println("Содержимое вашей корзины");
                System.out.println(cart + "\n");
            }

        }

    }
}
