package com.example.final_v1.Product.Service;

import com.example.final_v1.Product.Model.Product;
import com.example.final_v1.Product.Repository.ProductRepository;
import com.example.final_v1.Product.Service.ProductService;
import com.example.final_v1.ProductTag.Model.ProductTag;
import com.example.final_v1.ProductTag.Repository.ProductTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTagRepository productTagRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public int addProduct(Product product) {
        List<Product> allProducts = productRepository.findAll();
        if(!allProducts.contains(product)){
            productRepository.save(product);

            Set<ProductTag> tagList = product.getProductTags();
            if(tagList != null) {
                for(ProductTag productTag : tagList){
                    productTag.getProducts().add(product);
                    productTagRepository.save(productTag);
                }
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateProduct(long id, Product product) {
        Optional<Product> found = productRepository.findById(id);
        if(found.isPresent()){
            found.get().setTitle(product.getTitle());
            found.get().setDescription(product.getDescription());
            found.get().setPrice(product.getPrice());
            found.get().setProductTags(product.getProductTags());
            found.get().setUpdated_at(product.getUpdated_at());
            productRepository.save(found.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteProduct(long id) {
        Optional<Product> found = productRepository.findById(id);
        if(found.isPresent()){
            productRepository.delete(found.get());
            return 1;
        }
        return 0;
    }

    @Override
    public Page<Product> findPaginate(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return productRepository.findAll(pageable);
    }
}
