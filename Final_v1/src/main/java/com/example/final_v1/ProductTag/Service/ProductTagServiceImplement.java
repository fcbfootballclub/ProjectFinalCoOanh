package com.example.final_v1.ProductTag.Service;

import com.example.final_v1.ProductTag.Controller.Model.ProductTag;
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
    public int addTag(ProductTag tag) {
        List<ProductTag> allTag = productTagRepository.findAll();
        if(!allTag.contains(tag)){
            productTagRepository.save(tag);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateTag(long id, ProductTag tag) {
        Optional<ProductTag> found = productTagRepository.findById(id);
        if(found.isPresent()){
            found.get().setTagName(tag.getTagName());
            productTagRepository.save(found.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteTag(long id) {
        Optional<ProductTag> found = productTagRepository.findById(id);
        if(found.isPresent()){
            productTagRepository.delete(found.get());
            return 1;
        }
        return 0;
    }
}
