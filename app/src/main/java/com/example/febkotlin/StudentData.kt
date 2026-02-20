package com.example.febkotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class StudentData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fullname: String,
    val branch: String,
    val enrollment: String,
    val semester: String

)
