package com.cagataysencan.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cagataysencan.todoapp.repo.TasksDaoRepo

class DetayViewModel(application: Application) : AndroidViewModel(application) {
    val repo = TasksDaoRepo(application)

    fun update(task_id : Int, task_name : String) {
        repo.updateTask(task_id,task_name)
    }

}