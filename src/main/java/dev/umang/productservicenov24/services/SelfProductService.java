package dev.umang.productservicenov24.services;

import dev.umang.productservicenov24.exceptions.ProductNotFoundException;
import dev.umang.productservicenov24.models.Category;
import dev.umang.productservicenov24.models.Product;
import dev.umang.productservicenov24.repositories.CategoryRepository;
import dev.umang.productservicenov24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public SelfProductService(CategoryRepository categoryRepository,
                              ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {
        Product p = new Product();
        //p.setId(12);
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(imageUrl);
        //p.setCreatedAt();

        Category categoryFromDB = categoryRepository.findByTitle(category);

        if(categoryFromDB == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);

            categoryFromDB = newCategory;
        }

        p.setCategory(categoryFromDB);
        Product createdProduct = productRepository.save(p);


        return createdProduct;
    }
}
