package com.nanolabs.kotlinroomtutorial

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert()
    fun insert(studentClass: StudentClass)

    @Query("select * from student ORDER BY name ASC")
     fun getStudentList():List<StudentDataClass>
}