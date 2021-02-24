package ru.geekbrains.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService=context.getBean("productService",ProductService.class);
        System.out.println("Введите команду");
        for (int i=0; i<10; i++){
            System.out.println(productService.crud(scanner.nextLine()));
        }

        context.close();
    }
}
