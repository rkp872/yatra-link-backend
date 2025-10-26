package com.yatralink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yatralink.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
