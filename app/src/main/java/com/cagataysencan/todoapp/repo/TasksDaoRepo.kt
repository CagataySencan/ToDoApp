package com.cagataysencan.todoapp.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.cagataysencan.todoapp.entity.Tasks
import com.cagataysencan.todoapp.room.TaskDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class TasksDaoRepo(var application: Application) {
    var taskList : MutableLiveData<List<Tasks>>
    var db : TaskDatabase
    init {
        taskList = MutableLiveData()
        db = TaskDatabase.databaseAccess(application)!!
    }

    fun getTasks() : MutableLiveData<List<Tasks>> {
        return taskList
    }

    fun addTask(task_name : String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newTask = Tasks(0,task_name)
            db.databaseDao().addTask(newTask)
        }
    }
    fun updateTask(task_id: Int,task_name: String) {
        val job =  CoroutineScope(Dispatchers.Main).launch {
            val updatedTask = Tasks(task_id,task_name)
            db.databaseDao().updateTask(updatedTask)
        }
    }

    fun searchTask(keyword : String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            taskList.value = db.databaseDao().searchTask(keyword)
        }
    }

    fun deleteTask(task_id : Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val remove = Tasks(task_id,"")
            db.databaseDao().deleteTask(remove)
            getAllTasks()
        }
    }

    fun getAllTasks() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            taskList.value = db.databaseDao().getAllTasks()
        }
    }

}