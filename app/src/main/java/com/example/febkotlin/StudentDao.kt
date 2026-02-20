package com.example.febkotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface StudentDao {

    @Insert
    suspend fun insert(studentData: StudentData)


    @Query("SELECT * FROM student_table")
    suspend fun getAllStudents(): List<StudentData>


}