package sv.edu.udb.detaquito

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class compra : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var  drawer: DrawerLayout
    private lateinit var  toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)
        val toolbar: androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer=findViewById(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        //para datos  de tabla
         val txt  = findViewById<TextView>(R.id.Recibir)
         val bundle = intent.extras
        val dato = bundle?.getString("nombre")
         txt.setText(dato)


        val btncarrito = findViewById<ImageButton>(R.id.btncarritoCompra)
        btncarrito.setOnClickListener {
            Toast.makeText(this,"Hola papu", Toast.LENGTH_SHORT).show()
        val bundle =intent.extras
        val taquito = bundle?.getString("taquitoo")

        //btn.setOnClickListener {

        //}



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
            R.id.nav_item_three -> {
                Toast.makeText(this,"Hola papu",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_fourth -> {
                val intentgooglemap = Intent(this,GoogleMaps::class.java)
                startActivity(intentgooglemap)
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