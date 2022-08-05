package com.example.final_v1.Product.Repository;

import com.example.final_v1.Product.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     * @param pageable
     * @return a page of entities
     */
    Page<Product> findAll(Pageable pageable);
}
