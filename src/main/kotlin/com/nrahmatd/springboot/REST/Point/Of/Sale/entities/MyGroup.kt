package com.nrahmatd.springboot.REST.Point.Of.Sale.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "mygroup")
data class MyGroup(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgroup", unique = true, nullable = false)
    var idgroup: Int = 0,

    @Column(name = "group_name", nullable = false)
    var group_name: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "created", nullable = false)
    var created: String,

    @Column(name = "createdby", nullable = false)
    var createdby: String,

    @Column(name = "updated", nullable = false)
    var updated: String,

    @Column(name = "updatedby", nullable = false)
    var updatedby: String,

    /** This code if activate error infinite */
//    @ManyToMany(mappedBy = "group", cascade = [CascadeType.ALL])
//    @JsonBackReference
//    val user: Set<User>
): Serializable