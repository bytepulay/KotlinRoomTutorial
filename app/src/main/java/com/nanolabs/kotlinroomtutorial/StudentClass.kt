package com.nanolabs.kotlinroomtutorial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
 class StudentClass{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    @ColumnInfo(name = "name")
    lateinit var studentName:String
    @ColumnInfo(name = "age")
    var age:Int = 0
}



