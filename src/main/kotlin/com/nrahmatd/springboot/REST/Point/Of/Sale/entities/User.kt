package com.nrahmatd.springboot.REST.Point.Of.Sale.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.nrahmatd.springboot.REST.Point.Of.Sale.basemodel.BaseResponseModel
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser", unique = true, nullable = false)
    var iduser: Int = 0,

    @Column(name = "username", nullable = false)
    var username: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "status", nullable = false)
    var status: String,

    @Column(name = "created", nullable = false)
    var created: String,

    @Column(name = "createdby", nullable = false)
    var createdby: String,

    @Column(name = "updated", nullable = false)
    var updated: String,

    @Column(name = "updatedby", nullable = false)
    var updatedby: String,

    @ManyToMany
    @JoinTable(
        name = "user_group",
        joinColumns = [JoinColumn(name = "iduser")],
        inverseJoinColumns = [JoinColumn(name = "idgroup")]
    )
    @JsonManagedReference
    var group: Set<MyGroup>
): BaseResponseModel {
    override val message: String
        get() = "Get Data"
    override val success: Int
        get() = 1
}
