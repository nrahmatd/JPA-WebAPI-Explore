package com.nrahmatd.springboot.REST.Point.Of.Sale.service

import com.nrahmatd.springboot.REST.Point.Of.Sale.entities.User
import com.nrahmatd.springboot.REST.Point.Of.Sale.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService {
    @Autowired
    private val userRepository: UserRepository? = null
    fun getAllUser(): List<User> {
        return userRepository!!.findAll()
    }

    fun saveUser(user: User) {
        userRepository!!.save(user)
    }

    fun getUserById(id: Int): User {
        return userRepository!!.findById(id).get()
    }

    fun login(username: String, password: String): User {
        return userRepository!!.login(username, password)
    }

    fun deleteUser(id: Int) {
        userRepository!!.deleteById(id)
    }
}