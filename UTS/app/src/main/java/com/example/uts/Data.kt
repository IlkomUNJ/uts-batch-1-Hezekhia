package com.example.uts

import androidx.compose.runtime.mutableStateListOf

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String
)

object StudentRepository {
    val studentList = mutableStateListOf<Student>()
}