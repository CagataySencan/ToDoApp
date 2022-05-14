package com.cagataysencan.todoapp.room

import androidx.room.*
import com.cagataysencan.todoapp.entity.Tasks


@Dao
interface DatabaseDao {

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks() : List<Tasks>

    @Insert
    suspend fun addTask(task : Tasks)

    @Update
    suspend fun updateTask(task : Tasks)

    @Delete
    suspend fun deleteTask(task : Tasks)

    @Query("SELECT * FROM tasks WHERE task_name LIKE '%'|| :aramaKelimesi || '%'")
    suspend fun searchTask(aramaKelimesi : String) : List<Tasks>
}