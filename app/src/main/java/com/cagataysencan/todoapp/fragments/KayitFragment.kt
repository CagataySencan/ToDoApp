package com.cagataysencan.todoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.cagataysencan.todoapp.R
import com.cagataysencan.todoapp.databinding.FragmentKayitBinding
import com.cagataysencan.todoapp.viewmodel.KayitViewModel
import com.cagataysencan.todoapp.viewmodel.KayitViewModelVMF


class KayitFragment : Fragment() {
    private lateinit var tasarim : FragmentKayitBinding
    private lateinit var viewModel : KayitViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit, container, false)

        tasarim.kayitFragment = this
        tasarim.kayitToolbarBaslik= "Add Task"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : KayitViewModel by viewModels() {
            KayitViewModelVMF(requireActivity().application)
        }
        viewModel = temp
    }
    fun addTask(task_name : String) {
        viewModel.addTask(task_name)
    }

}