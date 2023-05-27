package com.nrahmatd.springboot.REST.Point.Of.Sale.controller

import com.nrahmatd.springboot.REST.Point.Of.Sale.basemodel.ResponseModel
import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.Customer
import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.Supplier
import com.nrahmatd.springboot.REST.Point.Of.Sale.service.CustomerService
import com.nrahmatd.springboot.REST.Point.Of.Sale.service.SupplierService
import com.nrahmatd.springboot.REST.Point.Of.Sale.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(path= ["/restapi"])
class MainController {
    @Autowired
    private val customerService: CustomerService? = null

    @Autowired
    private val supplierService: SupplierService? = null

    @Autowired
    private val userService: UserService? = null

    /**
     * Customer Web API
     */

    @PostMapping(path = ["/addcustomer"])
    @ResponseBody
    fun addNewCustomer(
        @RequestParam name: String,
        @RequestParam gender: String,
        @RequestParam address: String,
        @RequestParam phone: String,
        @RequestParam createdby: String,
        @RequestParam updatedby: String
    ): ResponseModel? {
        val customer = Customer(
            name = name,
            gender = gender,
            address = address,
            phone = phone,
            createdby = createdby,
            updatedby = updatedby
        )

        val responseModel: ResponseModel = try {
            customerService!!.saveCustomer(customer)
            ResponseModel("Successfully saving data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error saving data $e", 0)
        }

        return responseModel
    }

    @PutMapping(path = ["/updatecustomer"])
    @ResponseBody
    fun updateCustomer(
        @RequestParam idcustomer: Int,
        @RequestParam name: String,
        @RequestParam gender: String,
        @RequestParam address: String,
        @RequestParam phone: String,
        @RequestParam updatedby: String
    ): ResponseModel? {
        val customer = Customer(
            idcustomer = idcustomer,
            name = name,
            gender = gender,
            address = address,
            phone = phone,
            updatedby = updatedby
        )

        val responseModel: ResponseModel = try {
            customerService!!.updateCustomer(customer)
            ResponseModel("Successfully update data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error update data $e", 0)
        }

        return responseModel
    }

    @DeleteMapping(path = ["/deletecustomer/{idcustomer}"])
    @ResponseBody
    fun deleteCustomer(
        @PathVariable idcustomer: Int
    ): ResponseModel? {
        val responseModel: ResponseModel = try {
            customerService!!.deleteCustomer(idcustomer)
            ResponseModel("Successfully delete data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error delete data $e", 0)
        }

        return responseModel
    }

    @PostMapping(path = ["/getcustomer"])
    @ResponseBody
    fun getCustomer(
        @RequestParam idcustomer: Int
    ): Customer {
        return customerService!!.getCustomerById(idcustomer)
    }

    @GetMapping(path = ["/getallcustomer"])
    @ResponseBody
    fun getAllCustomer(): Iterable<Customer?>? {
        return customerService!!.getAllCustomer()
    }

    /**
     * Supplier Web API
     */

    @PostMapping(path = ["/addsupplier"])
    @ResponseBody
    fun addNewSupplier(
        @RequestParam name: String,
        @RequestParam address: String,
        @RequestParam phone: String,
        @RequestParam description: String,
        @RequestParam createdby: String,
        @RequestParam updatedby: String
    ): ResponseModel? {
        val supplier = Supplier(
            name = name,
            address = address,
            phone = phone,
            description = description,
            createdby = createdby,
            updatedby = updatedby
        )

        val responseModel: ResponseModel = try {
            supplierService!!.saveSupplier(supplier)
            ResponseModel("Successfully saving data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error saving data $e", 0)
        }

        return responseModel
    }

    @PutMapping(path = ["/updatesupplier"])
    @ResponseBody
    fun updateSupplier(
        @RequestParam idsupplier: Int,
        @RequestParam name: String,
        @RequestParam address: String,
        @RequestParam phone: String,
        @RequestParam description: String,
        @RequestParam updatedby: String
    ): ResponseModel? {
        val supplier = Supplier(
            idsupplier = idsupplier,
            name = name,
            address = address,
            phone = phone,
            description = description,
            updatedby = updatedby
        )

        val responseModel: ResponseModel = try {
            supplierService!!.updateSupplier(supplier)
            ResponseModel("Successfully update data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error update data $e", 0)
        }

        return responseModel
    }

    @DeleteMapping(path = ["/deletesupplier/{idsupplier}"])
    @ResponseBody
    fun deleteSupplier(
        @PathVariable idsupplier: Int
    ): ResponseModel? {
        val responseModel: ResponseModel = try {
            supplierService!!.deleteSupplier(idsupplier)
            ResponseModel("Successfully delete data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error delete data $e", 0)
        }

        return responseModel
    }

    @PostMapping(path = ["/getsupplier"])
    @ResponseBody
    fun getSupplier(
        @RequestParam idsupplier: Int
    ): Supplier {
        return supplierService!!.getSupplierById(idsupplier)
    }

    @GetMapping(path = ["/getallsupplier"])
    @ResponseBody
    fun getAllSupplier(): Iterable<Supplier?>? {
        return supplierService!!.getAllSupplier()
    }

    /**
     * User Web API
     */

    @PostMapping(path = ["/login"])
    @ResponseBody
    fun login(
        @RequestParam username: String,
        @RequestParam password: String
    ): Any {
        return try {
            val userResponse = userService!!.login(username, password)
            userResponse
        } catch (e: DataAccessException) {
            if (e.toString().contains("Result must not be null")) {
                ResponseModel("Username or Password not valid", 0)
            } else {
                ResponseModel("Error $e", 0)
            }
        }
    }
}