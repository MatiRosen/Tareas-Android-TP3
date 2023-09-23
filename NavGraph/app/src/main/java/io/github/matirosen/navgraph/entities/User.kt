package io.github.matirosen.navgraph.entities

import java.io.Serializable

class User (email: String = "", password: String = "") : Serializable{
    private var email: String
    private var password: String

    init {
        this.email = email
        this.password = password
    }

    fun getEmail(): String {
        return this.email
    }

    fun getPassword(): String {
        return this.password
    }

    override fun toString(): String {
        return "User(email='$email', password='$password')"
    }
}