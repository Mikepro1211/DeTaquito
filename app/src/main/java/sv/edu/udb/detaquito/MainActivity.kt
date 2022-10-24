package sv.edu.udb.detaquito

import android.content.ContentValues
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val database = Firebase.database
    private lateinit var  drawer:DrawerLayout
    private lateinit var  toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //llamado al content view
        setContentView(R.layout.activity_main)
        val toolbar: androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer=findViewById(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        //variable firebase
        val myRef = database.getReference("Producto")


        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)
        //Funcion carrito

        val btnburrito =findViewById<Button>(R.id.BotonOrder1)
        val burrito = "Burrito"
        val precioburrio = 4.99

        btnburrito.setOnClickListener {

            val agregarBurrito = Producto(burrito.toString(),precioburrio.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarBurrito)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }

        val btnTorta  = findViewById<Button>(R.id.BotonOrder2)
        val torta = "Torta"
        val precioTorta  =8.00

        btnTorta.setOnClickListener {
            val  agregarTorta = Producto(torta.toString(),precioTorta.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarTorta)
            Toast.makeText(this,"Se agrego Torta al carrito",Toast.LENGTH_SHORT).show()
        }
       val btnNacho =findViewById<Button>(R.id.BotonOrder3)
       val Nacho=  "Nacho"
       val precioNacho= 2.99

       btnNacho.setOnClickListener {
           val agregarNacho= Producto(Nacho.toString(),precioNacho.toString())
           myRef.child(myRef.push().key.toString()).setValue(agregarNacho)
           Toast.makeText(this,"Se agrego Nacho al carrito",Toast.LENGTH_LONG).show()
       }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_one -> {
                val Intent = Intent(this,MainActivity::class.java)
                startActivity(Intent)

            }
            R.id.nav_item_two -> {
               val menu = Intent(this,Menu::class.java)
                startActivity(menu)

            }
            R.id.nav_item_three -> {
                Toast.makeText(this,"Hola mundo",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_fourth -> {
                val intentgooglemap = Intent(this,GoogleMaps::class.java)
                startActivity(intentgooglemap)
            }
            R.id.prueba -> {
                val prueba = Intent(this,comprita::class.java)
                startActivity(prueba)
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
    //CONEXION A BASE DE DATOS
}