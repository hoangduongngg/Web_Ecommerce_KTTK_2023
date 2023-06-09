package com.example.orderservice.repository;

import com.example.orderservice.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <OrderEntity, Integer> {
    Optional<OrderEntity> findByTblCustomeridAndStatusOrder (Integer id, String status);
    List <OrderEntity> findByTblCustomerid (Integer id);
    OrderEntity findOrderEntityById (Integer id);
    OrderEntity findByStatusOrder(String statusOrder);

    List<OrderEntity> findByPaymentDateBetween(Date dateStart, Date dateEnd);
//    List<OrderEntity> findByPaymentDateYearAndPaymentDateMonth(Integer year, Integer month);
    List<OrderEntity> findByPaymentDate(Date date);

}
