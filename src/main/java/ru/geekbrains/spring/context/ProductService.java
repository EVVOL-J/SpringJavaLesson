package ru.geekbrains.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String crud(String operation) {
        String[] split = operation.split(" ");
        if (split.length > 2) {
            return "incorrect command";
        }

        if (split.length==2)
        {
        try {Long id;
            id = Long.parseLong(split[1]);
            switch (split[0]) {
                case ("1"): {
                    Product p = new Product(id, "Vasya" + id, id * 2);
                    productRepository.addOrUpdate(p);
                    return p.toString() + "Добавлен или обновлен";

                }
                case ("2"): {
                    return productRepository.deleteById(id) ? "Удален" : "Такой товар отсутсвует";

                }
                case ("3"): {
                    return productRepository.getById(id).toString();
                }}
        } catch (NumberFormatException e) {
            return "incorrect command";
        }}
        switch (split[0]){
            case ("4"): {
                return "Число продуктов: "+ numberOfProducts();
            }
            case ("5"): {
                return "Средняя стоимость: "+ averageCost();
            }
            case ("6"): {
                return "Все продукты "+ productRepository.getProducts().toString();
            }

        }
        return "incorrect command";
    }

    public long numberOfProducts(){
        return productRepository.getProducts().size();
    }

    public long averageCost(){
        long sum=0;
        for (Product product:productRepository.getProducts())
        {
            sum=+product.getCost();
        }
        if (sum==0) return 0;
        else return sum/productRepository.getProducts().size();
    }

}


