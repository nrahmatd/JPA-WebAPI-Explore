package com.nrahmatd.springboot.REST.Point.Of.Sale.service

import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.Customer
import com.nrahmatd.springboot.REST.Point.Of.Sale.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class CustomerService {
    @Autowired
    private val customerRepository: CustomerRepository? = null
    fun getAllCustomer(): List<Customer> {
        return customerRepository!!.findAll()
    }

    fun saveCustomer(customer: Customer) {
        customerRepository!!.save(customer)
    }

    fun updateCustomer(customer: Customer) {
        val customerFromDB = getCustomerById(customer.idcustomer)
        customerFromDB.idcustomer = customer.idcustomer
        customerFromDB.name = customer.name
        customerFromDB.gender = customer.gender
        customerFromDB.address = customer.address
        customerFromDB.phone = customer.phone
        customerFromDB.updatedby = customer.updatedby

        customerRepository!!.save(customerFromDB)
    }

    fun getCustomerById(id: Int): Customer {
        return customerRepository!!.findById(id).get()
    }

    fun deleteCustomer(id: Int) {
        customerRepository!!.deleteById(id)
    }
}