package com.example.febkotlin

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}

