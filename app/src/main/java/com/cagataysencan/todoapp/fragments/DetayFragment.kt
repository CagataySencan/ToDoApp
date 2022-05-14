package com.cagataysencan.todoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cagataysencan.todoapp.R
import com.cagataysencan.todoapp.databinding.FragmentDetayBinding
import com.cagataysencan.todoapp.viewmodel.DetayViewModel
import com.cagataysencan.todoapp.viewmodel.DetayViewModelVMF


class DetayFragment : Fragment() {
    private lateinit var tasarim : FragmentDetayBinding
    private lateinit var viewModel : DetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)

        tasarim.detayFragment = this
        tasarim.detayToolbarBaslik = "Task Details"

        val bundle : DetayFragmentArgs by navArgs()
        val gelenTask = bundle.task


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : DetayViewModel by viewModels() {
            DetayViewModelVMF(requireActivity().application)
        }
        viewModel = temp
    }

    fun buttonUpdate(task_id : Int, task_name : String) {
        viewModel.update(task_id,task_name)
    }


}