package com.cagataysencan.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cagataysencan.todoapp.repo.TasksDaoRepo

class KayitViewModel(application: Application) : AndroidViewModel(application) {
    val repo = TasksDaoRepo(application)

    fun addTask(task_name : String) {
        repo.addTask(task_name)
    }
}