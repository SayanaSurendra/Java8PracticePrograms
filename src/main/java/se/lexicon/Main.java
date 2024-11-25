package se.lexicon;

import java.util.ArrayList;
import java.util.List;


public class Main {

     public static void processProducts(List<Product> products,Conditional conditional,Action action){
     for(Product p:products){
         if (conditional.test(p)) {
             action.execute(p);
         }
     }
     }
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone 6s", 100.00, 0));
        products.add(new Product("Iphone 7", 120.00, 7));
        products.add(new Product("Iphone SE", 120.00, 0));
        products.add(new Product("Iphone 8", 150.00, 5));
        products.add(new Product("Iphone 13", 5600.00, 25));
        products.add(new Product("Iphone 16", 10000.00, 25));
        products.add(new Product("Book of Apples History", 1500.00, 5));

        // 1. Print out all Products that have a stock value of 0.
        Conditional conditionalForZeroStock=(Product p) ->p.getStock()==0;
       Action printProduct=(Product p)-> System.out.println(p.toString());
       processProducts(products,conditionalForZeroStock,printProduct);


        // 2. Print out the productName of all the Products that starts with B.

        processProducts(products,
                (p) -> p.getProductName().startsWith("B"),
                (p) -> System.out.println(p.getProductName())
        );


        // 3. Print out all Products that have price above 100 AND lower than 150

        processProducts(products,
                (p) -> (p.getPrice() > 100 && p.getPrice() <150),
                (p) -> System.out.println(p.toString())
        );


      //  4. Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%

        Action increasePrice=(Product p) -> {
            p.setPrice(p.getPrice() * 1.50);
            System.out.println(p.toString());
        };
        processProducts(products,(p)->p.getStock() >0 && p.getStock() < 10, increasePrice);
     }
}