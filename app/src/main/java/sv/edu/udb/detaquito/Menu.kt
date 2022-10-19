package sv.edu.udb.detaquito

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Menu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var  drawer: DrawerLayout
    private lateinit var  toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val toolbar: androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer=findViewById(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        Toast.makeText(this,"Hola beba",Toast.LENGTH_SHORT).show()
        val btncarrito = findViewById<ImageButton>(R.id.btncarritoCompra)
        btncarrito.setOnClickListener {
            Toast.makeText(this,"Hola papu",Toast.LENGTH_SHORT).show()
        }
        val compra1 = findViewById<Button>(R.id.btnagregar_uno)
        compra1.setOnClickListener {
            val intento =  Intent(this,compra::class.java)
            startActivity(intento)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_one -> {
                val Intent = Intent(this,MainActivity::class.java)
                startActivity(Intent)

            }
            R.id.nav_item_two -> {
                val IntentMenu = Intent(this,Menu::class.java)
                startActivity(IntentMenu)

            }
            R.id.nav_item_three ->
            {
                Toast.makeText(this,"Hola papu",Toast.LENGTH_SHORT).show()

            }

            R.id.nav_item_fourth -> {
                Toast.makeText(this, "Item4", Toast.LENGTH_SHORT).show()
                val IntentMapa = Intent(this,GoogleMaps::class.java)
                startActivity(IntentMapa)
            }
            }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    }
