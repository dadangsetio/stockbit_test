package com.stockbit.hiring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // ---

    private fun configureNavController() {
        navController = findNavController(com.stockbit.hiring.R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        val toolbar = findViewById<MaterialToolbar>(com.stockbit.hiring.R.id.toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
