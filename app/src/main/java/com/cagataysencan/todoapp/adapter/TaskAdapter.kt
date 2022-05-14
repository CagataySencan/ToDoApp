package com.cagataysencan.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cagataysencan.todoapp.R
import com.cagataysencan.todoapp.databinding.TaskAdapterBinding
import com.cagataysencan.todoapp.entity.Tasks
import com.cagataysencan.todoapp.fragments.AnasayfaFragmentDirections
import com.cagataysencan.todoapp.viewmodel.AnaSayfaViewModel
import com.google.android.material.snackbar.Snackbar

class TaskAdapter(var context : Context, var taskList : List<Tasks>, var viewModel : AnaSayfaViewModel) : RecyclerView.Adapter<TaskAdapter.TaskAdapterViewHolder>(){
    inner class TaskAdapterViewHolder(tasarim : TaskAdapterBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim : TaskAdapterBinding
        init {
            this.tasarim = tasarim
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val tasarim : TaskAdapterBinding = DataBindingUtil.inflate(layoutInflater, R.layout.task_adapter, parent, false)
        return TaskAdapterViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: TaskAdapterViewHolder, position: Int) {
        val task = taskList.get(position)
        val t = holder.tasarim
        t.taskObject = task

        t.imageView.setOnClickListener {
            Snackbar.make(it,"${task.task_name} silinsin mi ?",Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.delete(task.task_id)
                }
                .show()
        }

        t.cardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaDetayGecis(task = task)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }


}