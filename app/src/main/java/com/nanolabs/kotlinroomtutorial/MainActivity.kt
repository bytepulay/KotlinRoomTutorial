package com.nanolabs.kotlinroomtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var db:StudentDataBase?=null
    private var studentDao:StudentDao?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.click)
        recyclerView.layoutManager = LinearLayoutManager(this)
        button.setOnClickListener{
            Observable.fromCallable {
                db = StudentDataBase.getAppDataBase(applicationContext)
                studentDao = db?.studentDao()

                var student = StudentClass()
                student.studentName = "naing lin tun"
                student.age = 10
                with(studentDao){
                    this?.insert(student)
                }
                db?.studentDao()?.getStudentList()
            }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                for (i in it?.indices!!){
                    Log.d("size",it?.get(i).studentName)
                    Toast.makeText(this,it?.get(i).studentName,Toast.LENGTH_LONG).show()
                }

                recyclerView.adapter = StudentAdapter(it!!,this)
            },{
                Log.d("error","error")
            })
        }
    }
}
