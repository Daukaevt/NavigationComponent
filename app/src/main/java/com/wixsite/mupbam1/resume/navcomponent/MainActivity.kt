package com.wixsite.mupbam1.resume.navcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.btFragmentMenu)
        val navController=findNavController(R.id.fragmentContainerView)
        val appBarConfiguration= AppBarConfiguration(
            setOf(R.id.poceViewFragment,R.id.poceSearchFragment,R.id.poceRndFragment,R.id.poceFavoritesFragment)
        )

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiguration)
    }
}