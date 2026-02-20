package com.example.febkotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class StudentDetailsActivity : AppCompatActivity() {
    val database = MyApp.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        val recyclerView = findViewById<RecyclerView>(R.id.rvlist)

        lifecycleScope.launch {

            val studentList = database.studentDao().getAllStudents()
            Log.e("data","data: $studentList")

            val adapter = StudentDetailsAdapter(database.studentDao().getAllStudents())
            recyclerView.layoutManager = LinearLayoutManager(this@StudentDetailsActivity)
            recyclerView.adapter = adapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}