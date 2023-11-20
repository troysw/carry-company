package com.carryCompany.carryCompany.order.external.order;

import com.carryCompany.carryCompany.common.exception.product.ProductItemNotFoundException;
import com.carryCompany.carryCompany.common.exception.product.ProductNotFoundException;
import com.carryCompany.carryCompany.order.application.outport.OrderReader;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.order.external.repository.OrderRepository;
import com.carryCompany.carryCompany.product.application.outport.ProductReader;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import com.carryCompany.carryCompany.product.domain.Product;
import com.carryCompany.carryCompany.product.domain.ProductItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class OrderReaderImpl implements OrderReader {

    private final OrderRepository orderRepository;

    @Override
    public List<MainOrder> findAllOrder() {
        return orderRepository.findAll();
    }
}
