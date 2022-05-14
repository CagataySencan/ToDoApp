package com.cagataysencan.todoapp.fragments

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.cagataysencan.todoapp.R
import com.cagataysencan.todoapp.adapter.TaskAdapter
import com.cagataysencan.todoapp.databinding.FragmentAnasayfaBinding
import com.cagataysencan.todoapp.viewmodel.AnaSayfaViewModel
import com.cagataysencan.todoapp.viewmodel.AnaSayfaViewModelVMF


class AnasayfaFragment : Fragment(), androidx.appcompat.widget.SearchView.OnQueryTextListener {
    private lateinit var tasarim : FragmentAnasayfaBinding
    private lateinit var viewModel : AnaSayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Görevler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.taskList.observe(viewLifecycleOwner) {
            val adapter = TaskAdapter(requireContext(),it,viewModel)
            tasarim.taskAdapter = adapter
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val temp : AnaSayfaViewModel by viewModels() {
            AnaSayfaViewModelVMF(requireActivity().application)
        }
        viewModel = temp
    }
    fun fabOnclick(v : View) {
        Navigation.findNavController(v).navigate(R.id.anasayfaKayitGecis)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        val item = menu.findItem(R.id.action_search)
        val search = item.actionView as androidx.appcompat.widget.SearchView
        search.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTasks()
    }


}