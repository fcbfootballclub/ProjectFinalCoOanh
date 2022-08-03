package com.example.final_v1.ProductTag.Service;

import com.example.final_v1.ProductTag.Model.ProductTag;
import com.example.final_v1.ProductTag.Repository.ProductTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTagServiceImplement implements ProductTagService{
    @Autowired
    ProductTagRepository productTagRepository;

    @Override
    public List<ProductTag> getAllTag() {
        return productTagRepository.findAll();
    }

    @Override
    public Optional<ProductTag> getTagById(long id) {
        return productTagRepository.findById(id);
    }

    @Override
    public void addTag(ProductTag tag) {
        productTagRepository.save(tag);
    }

    @Override
    public void updateTag(long id, ProductTag tag) {
        Optional<ProductTag> found = productTagRepository.findById(id);
        if(found.isPresent()){
            found.get().setTagName(tag.getTagName());
            productTagRepository.save(found.get());
        }
    }

    @Override
    public void deleteTag(long id) {
        productTagRepository.deleteById(id);
    }
}
