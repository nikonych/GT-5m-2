package com.example.gt_5m_2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gt_5m_2.databinding.ActivityMainBinding
import com.example.gt_5m_2.ui.main.MainFragmentDirections
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = binding.navView


//            navController.navigate(MainFragmentDirections.actionMainFragmentToOnBoardFragment())
//        navController.navigate(R.id.mainFragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_history,
                R.id.navigation_home,
            )
        )

        val bottomNavFragments = arrayListOf(
            R.id.navigation_home,
            R.id.navigation_history,
            R.id.resultFragment
        )

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            navView.isVisible = bottomNavFragments.contains(destination.id)
            if (destination.id == R.id.onBoardFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }
        navView.setupWithNavController(navController)


        setupActionBarWithNavController(navController, appBarConfiguration)
    }


}