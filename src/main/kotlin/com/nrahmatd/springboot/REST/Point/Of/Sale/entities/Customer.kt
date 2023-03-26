package com.nrahmatd.springboot.REST.Point.Of.Sale.entities

import com.nrahmatd.springboot.REST.Point.Of.Sale.basemodel.BaseResponseModel
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer", unique = true, nullable = false)
    var idcustomer: Int = 0,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "gender", nullable = false)
    var gender: String,

    @Column(name = "address", nullable = false)
    var address: String,

    @Column(name = "phone", nullable = false)
    var phone: String,

    @Column(name = "idsales", nullable = true)
    var idsales: String? = null,

    @Column(name = "created", nullable = false)
    var created: String? = LocalDateTime.now().toString(),

    @Column(name = "createdby", nullable = true)
    var createdby: String? = null,

    @Column(name = "updated", nullable = false)
    var updated: String? = LocalDateTime.now().toString(),

    @Column(name = "updatedby", nullable = false)
    var updatedby: String
): BaseResponseModel {
    override val message: String
        get() = "Get Data"
    override val success: Int
        get() = 1
}