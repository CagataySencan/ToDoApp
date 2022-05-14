package com.cagataysencan.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cagataysencan.todoapp.entity.Tasks
import com.cagataysencan.todoapp.repo.TasksDaoRepo

class AnaSayfaViewModel(application: Application) : AndroidViewModel(application) {
    val repo = TasksDaoRepo(application)
    var taskList = MutableLiveData<List<Tasks>>()
    init {

    }
    fun search(keyword : String) {
        repo.searchTask(keyword)
    }

    fun delete(task_id : Int) {
        repo.deleteTask(task_id)
    }

    fun getTasks(){
        repo.getTasks()
    }
}