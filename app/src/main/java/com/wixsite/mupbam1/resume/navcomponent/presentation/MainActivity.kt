package com.wixsite.mupbam1.resume.navcomponent.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wixsite.mupbam1.resume.navcomponent.R
import com.wixsite.mupbam1.resume.navcomponent.database.UserEntity
import com.wixsite.mupbam1.resume.navcomponent.databinding.ActivityMainBinding
import com.wixsite.mupbam1.resume.navcomponent.databinding.FragmentPoceViewBinding
import com.wixsite.mupbam1.resume.navcomponent.di.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_poce_search.*

class MainActivity : AppCompatActivity() {

    lateinit var fragmentView: PoceSearchFragment

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Navigation
        fragmentView=PoceSearchFragment()

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.btFragmentMenu)
        val navController=findNavController(R.id.fragmentContainerView)
        val appBarConfiguration= AppBarConfiguration(
            setOf(
                R.id.poceViewFragment,
                R.id.poceSearchFragment,
                R.id.poceRndFragment,
                R.id.poceFavoritesFragment
            )
        )

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiguration)


    }

}