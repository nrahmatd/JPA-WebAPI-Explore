package com.nrahmatd.springboot.REST.Point.Of.Sale.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user_group")
data class UserGroup(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser_group", unique = true, nullable = false)
    var iduser_group: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = User::class)
    @JoinColumn(name = "iduser", nullable = false)
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = MyGroup::class)
    @JoinColumn(name = "idgroup", nullable = false)
    var group: MyGroup,

    @Column(name = "created", nullable = false)
    var created: String,

    @Column(name = "createdby", nullable = false)
    var createdby: String,

    @Column(name = "updated", nullable = false)
    var updated: String,

    @Column(name = "updatedby", nullable = false)
    var updatedby: String
)