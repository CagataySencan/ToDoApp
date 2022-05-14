package com.cagataysencan.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cagataysencan.todoapp.entity.Tasks

@Database(entities = [Tasks::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun databaseDao() : DatabaseDao

    companion object {
        var INSTANCE : TaskDatabase? = null

        fun databaseAccess(context : Context) : TaskDatabase? {
            if(INSTANCE == null) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "tasks.sqlite")
                        .createFromAsset("tasks.sqlite").build()
                }
            }
            return INSTANCE
        }
    }

}