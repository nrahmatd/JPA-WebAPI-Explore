package com.nrahmatd.springboot.REST.Point.Of.Sale.service

import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.Customer
import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.Supplier
import com.nrahmatd.springboot.REST.Point.Of.Sale.repositories.CustomerRepository
import com.nrahmatd.springboot.REST.Point.Of.Sale.repositories.SupplierRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class SupplierService {
    @Autowired
    private val supplierRepository: SupplierRepository? = null
    fun getAllSupplier(): List<Supplier> {
        return supplierRepository!!.findAll()
    }

    fun saveSupplier(supplier: Supplier) {
        supplierRepository!!.save(supplier)
    }

    fun updateSupplier(supplier: Supplier) {
        val supplierFromDB = getSupplierById(supplier.idsupplier)
        supplierFromDB.idsupplier = supplier.idsupplier
        supplierFromDB.name = supplier.name
        supplierFromDB.address = supplier.address
        supplierFromDB.phone = supplier.phone
        supplierFromDB.description = supplier.description
        supplierFromDB.updatedby = supplier.updatedby

        supplierRepository!!.save(supplierFromDB)
    }

    fun getSupplierById(id: Int): Supplier {
        return supplierRepository!!.findById(id).get()
    }

    fun deleteSupplier(id: Int) {
        supplierRepository!!.deleteById(id)
    }
}