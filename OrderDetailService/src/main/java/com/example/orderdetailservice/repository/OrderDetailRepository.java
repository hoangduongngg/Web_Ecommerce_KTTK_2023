package com.example.orderdetailservice.repository;

import com.example.orderdetailservice.model.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository <OrderDetailEntity, Long> {
    OrderDetailEntity findByTblOrderidAndTblProductid (Integer orderID, Integer productID);
    List<OrderDetailEntity> findByTblOrderid (Integer orderID);

}
