package java1.stream1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static void printProduct(Product p) {
        System.out.println("Product: " + p.name + " for just " + p.price);
    }
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();

        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        //productsList.forEach(p -> System.out.println(p));
        productsList.forEach(System.out::println); //  System.out.println(p)
        System.out.println("=================");

        //productsList.forEach(p -> printProduct(p)); //  System.out.println(p)
        productsList.forEach(Main::printProduct); //  System.out.println(p)
        System.out.println("=================");


        List<Float> productPriceList2 = productsList.stream()

                .filter(p -> p.price > 30000)// filtering data

                .map(p->p.price)        // fetching price

                .collect(Collectors.toList()); // collecting as list

        List<Float> prices_beyond_30k = new ArrayList<>();
        for (var product: productsList) {
            if (product.price > 30000) {
                prices_beyond_30k.add(product.price);
            }
        }

        System.out.println(productPriceList2);





    }
}
