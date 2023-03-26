package com.nrahmatd.springboot.REST.Point.Of.Sale.repositories

import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Int>