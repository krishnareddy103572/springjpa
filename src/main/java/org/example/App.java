package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionManager;

import javax.transaction.Transaction;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        TransactionManager transactionManager;

        System.out.println( "Spring JPA program started...." );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ProductRepositoryImpl productRepository = context.getBean("product",ProductRepositoryImpl.class);

        Product p = new Product();
        p.setName("Laptop");
       p.setDescription("Use to code");
       p.setId(123);


        productRepository.save(p);

        System.out.println("values inserted into table.."+p);

        // Example: Querying products
//        List<Product> products = productRepository.findAll();
//        products.forEach(p1 -> System.out.println("Product: " + p1.getName() + ", Price: " + p1.getDescription()+",Id: "+p1.getId()));

        ((ClassPathXmlApplicationContext) context).close();
    }
}
