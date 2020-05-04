package com.nanolabs.kotlinroomtutorial

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(StudentClass::class),version = 1)
abstract class StudentDataBase :RoomDatabase(){
    abstract fun studentDao():StudentDao

    companion object{
        var INSTANCE:StudentDataBase?=null
        fun getAppDataBase(context: Context):StudentDataBase?{
            if (INSTANCE==null){
                synchronized(StudentDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,StudentDataBase::class.java,"studentdb").build()
                }
            }

            return INSTANCE
        }
    }
}