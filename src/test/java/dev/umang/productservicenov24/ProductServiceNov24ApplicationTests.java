package dev.umang.productservicenov24;

import dev.umang.productservicenov24.models.Product;
import dev.umang.productservicenov24.projections.ProductProjection;
import dev.umang.productservicenov24.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceNov24ApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries(){
//        List<Product> products= productRepository.
//                findAllByCategory_Title("electronics");
//        System.out.println(products);
//
//
//        List<Product> productList = productRepository.findAllByCategory_Id(1L);
//
//        System.out.println(productList);


        //List<Product> products1 = productRepository.getTitlesAndIdOfAllProductsWithGivenCategoryName..("xyz");
        //System.out.println(products1);

        List<ProductProjection> productProjections = productRepository.getTitlesAndIdOfAllProductsWithGivenCategoryName("electronics");

        for(ProductProjection productProjection: productProjections){
            System.out.println(productProjection.getId());
            System.out.println(productProjection.getTitle());
        }
        System.out.println();
    }

}
