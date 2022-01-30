package com.wixsite.mupbam1.resume.navcomponent.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wixsite.mupbam1.resume.navcomponent.R
import com.wixsite.mupbam1.resume.navcomponent.database.UserEntity
import com.wixsite.mupbam1.resume.navcomponent.databinding.FragmentPoceSearchBinding
import com.wixsite.mupbam1.resume.navcomponent.di.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_poce_search.*

class PoceSearchFragment : Fragment() {
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPoceSearchBinding.inflate(layoutInflater, container, false)
        binding.btSave.setOnClickListener {
            val userEntity= UserEntity(name = edEnterDescription.text.toString())
            viewModel.insertRecord(userEntity)
            tvResult.setText("")
        }
        initViewModel()
        return binding.root

        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_poce_search, container, false)
    }
    private fun initViewModel(){
        viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecordsObserver().observe(viewLifecycleOwner,object: Observer<List<UserEntity>>
        {
            override fun onChanged(t: List<UserEntity>?) {
                tvResult.setText("")
                t?.forEach {
                    tvResult.append(it.name+"\n")
                }
            }
        })
    }
}