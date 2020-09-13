package com.dm.tutorialadddrawer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle                 //Importazione della Classe: ActionBarDrawerToggle
import androidx.core.view.GravityCompat                             //Importazione della Classe: GravityCompat
import androidx.drawerlayout.widget.DrawerLayout                    //Importazione della Classe: DrawerLayout
import com.google.android.material.navigation.NavigationView        //Importazione della Classe: NavigationView
import androidx.appcompat.widget.Toolbar                            //Importazione della Classe: Toolbar

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }


    //funzione che gestisce il click del tasto indietro del dispositivo
    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        //se il menu laterale (Drawer) è aperto
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            //chiude il Drawer
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else
        {
            //chiude l'applicazione
            super.onBackPressed()
        }
    }


    //funzione che gestisce il click degli elementi che compongono il menu laterale
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_elemento1 -> {
                Toast.makeText(this, "Elemento 1", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_elemento2 -> {
                Toast.makeText(this, "Elemento 2", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_elemento3 -> {
                Toast.makeText(this, "Elemento 3", Toast.LENGTH_SHORT).show()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
