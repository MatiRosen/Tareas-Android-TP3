package io.github.matirosen.bottomnavview.activities

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.iterator
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import io.github.matirosen.bottomnavview.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupVariables()
        setupBottomNavMenu()
        setupNavigationView()
    }

    private fun setupVariables(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        this.navController = navHostFragment.navController
        this.drawerLayout = findViewById(R.id.drawerLayoutMain)
        this.appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        this.toolbar = findViewById(R.id.toolbar_main)
        toolbar.setNavigationIcon(R.drawable.hamburger)
    }

    private fun setupBottomNavMenu() {
        NavigationUI.setupWithNavController(findViewById<BottomNavigationView>(R.id.bottomNavigationView), navController)
    }

    private fun setupNavigationView(){
        val navView = findViewById<NavigationView>(R.id.navViewMain)
        navView.setupWithNavController(navController)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        navView.menu.iterator().forEach {
            it.setActionView(R.layout.drawer_layout_image)
        }

        navController.addOnDestinationChangedListener { _, _, _ ->
            findViewById<TextView>(R.id.txtToolbarTitle).text = navController.currentDestination?.label
            toolbar.setNavigationIcon(R.drawable.hamburger)
        }

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_nav_menu, menu)
        return true
    }
}