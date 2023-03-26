package com.nrahmatd.springboot.REST.Point.Of.Sale.repositories

import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {

    @Query(value = "SELECT u.* FROM simplepos.user u join user_group ug ON u.iduser = ug.iduser join mygroup g ON ug.idgroup = g.idgroup where u.username = :username AND u.password = :password AND u.status = 'active'", nativeQuery = true)
    fun login(@Param("username") username: String, @Param("password") password: String): User

}