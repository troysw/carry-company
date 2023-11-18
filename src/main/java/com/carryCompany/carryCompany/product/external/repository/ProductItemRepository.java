package com.carryCompany.carryCompany.product.external.repository;

import com.carryCompany.carryCompany.product.domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findAllByProduct_productId(Long id);
}
