package com.nanolabs.kotlinroomtutorial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
 data class StudentDataClass(@ColumnInfo(name = "name") var studentName:String, @ColumnInfo(name = "age") var age:Int )




