package dev.jakubzika.worktracker.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.jakubzika.worktracker.R
import dev.jakubzika.worktracker.extensions.visible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val bottomNavigationScreens = setOf(
        R.id.timerFragment,
        R.id.projectsFragment,
        R.id.settingsFragment
    )

//    private val toolbarScreens = setOf(
//        R.id.timerFragment
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {

        val navController = findNavController(this, R.id.nav_host_fragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val appBarConfiguration = AppBarConfiguration(bottomNavigationScreens)
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            bottomNavigationView.visible = destination.id in bottomNavigationScreens
//            toolbar.visible = destination.id in toolbarScreens
        }
    }
}
