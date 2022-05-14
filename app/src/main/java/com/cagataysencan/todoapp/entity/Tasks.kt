package com.cagataysencan.todoapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "tasks")
data class Tasks(

    @ColumnInfo(name = "task_id")
    @NotNull
    @PrimaryKey(autoGenerate = true)
    var task_id : Int,

    @ColumnInfo(name = "task_name")
    @NotNull
    var task_name : String,
) : Serializable