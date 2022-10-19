package sv.edu.udb.detaquito

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.navigation.NavigationView

class GoogleMaps : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener,OnMapReadyCallback{
    private lateinit var maps: GoogleMap
    private lateinit var  drawer: DrawerLayout
    private lateinit var  toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps)
        createFragment()
        val toolbar: androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer=findViewById(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        val btncarrito = findViewById<ImageButton>(R.id.btncarritoCompra)
        btncarrito.setOnClickListener {
            Toast.makeText(this,"Hola papu", Toast.LENGTH_SHORT).show()
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
            R.id.nav_item_three -> Toast.makeText(this,"Item3",Toast.LENGTH_SHORT).show()
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


    private fun  createFragment(){
        val mapFragment:SupportMapFragment =supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        maps =googleMap
        createMarker()
    }

    private fun createMarker(){
        val coordenadas =LatLng(13.701283690339798, -89.22480881222684)
        val marcador :MarkerOptions = MarkerOptions().position(coordenadas).title("Nuestra sucursal")
        maps.addMarker(marcador)
        maps.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordenadas,18f),4000,null
        )
    }
}