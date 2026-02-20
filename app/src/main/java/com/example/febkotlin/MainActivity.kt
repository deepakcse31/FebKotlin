package com.example.febkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val userId ="1234"
    var userName ="Dev"
    lateinit var name: String

    lateinit var edtfullname: EditText
    lateinit var edtbranch: EditText
    lateinit var edtenrollment: EditText
    lateinit var edtsemester: EditText
    lateinit var btnsubmit: Button
    lateinit var btnviewall: Button


    val database=MyApp.database

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        userName="DevKotlin"
        name="DevAndroid"
        Log.e("MainActivity", "userName: $userName")
        Log.e("MainActivity", "name: $name")

        edtfullname = findViewById(R.id.edtfullname)
        edtbranch = findViewById(R.id.edtbranch)
        edtenrollment = findViewById(R.id.edtenrollment)
        edtsemester = findViewById(R.id.edtsemester)
        btnsubmit = findViewById(R.id.btnsubmit)
        btnviewall  =findViewById(R.id.btnviewall)

        btnviewall.setOnClickListener {

            val intent = Intent(this, StudentDetailsActivity::class.java)
            startActivity(intent)
        }


        btnsubmit.setOnClickListener {

            val fullname = edtfullname.text.toString()
            val branch = edtbranch.text.toString()
            val enrollment = edtenrollment.text.toString()
            val semester = edtsemester.text.toString()

            lifecycleScope.launch {
                database.studentDao().insert(StudentData(
                    fullname = fullname,
                    branch = branch,
                    enrollment = enrollment,
                    semester = semester
                ))

                edtfullname.setText("")
                edtbranch.setText("")
                edtenrollment.setText("")
                edtsemester.setText("")
            }



            Log.e("MainActivity", "fullname: $fullname")
            Log.e("MainActivity", "branch: $branch")
            Log.e("MainActivity", "enrollment: $enrollment")
            Log.e("MainActivity", "semester: $semester")

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}