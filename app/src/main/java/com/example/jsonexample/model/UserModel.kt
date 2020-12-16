package com.example.jsonexample.model

data class User(
    val users: ArrayList<UserModel>
)

data class UserModel(
    val id: Int,
    val name: String,
    val email: String,
    val gender: String,
    val weight: Double,
    val height: Int,
    val phone: Phone
)

data class Phone(
    val mobile: String,
    val office: String,
    val details: Details
)

data class Details(
    val brand: String,
    val model: String
)