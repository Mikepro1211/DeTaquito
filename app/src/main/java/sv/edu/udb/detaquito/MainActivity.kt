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

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
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
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        /*Datos para base de tados*/
        val orden_de_tacos =findViewById<TextView>(R.id.orden_de_tacos)
        val precio = findViewById<TextView>(R.id.some_id)

        //Funcion carrito
        val btncarrito = findViewById<ImageButton>(R.id.btncarritoCompra)
        btncarrito.setOnClickListener {
            Toast.makeText(this,"Hola papu no tengo funcion",Toast.LENGTH_SHORT).show()
        }

        //Funcion Boton Ordenar yaa!
        val btnordenayaa = findViewById<Button>(R.id.ordenayaa)
        btnordenayaa.setOnClickListener {
            val llevarmenu = Intent(this,Menu::class.java)
            startActivity(llevarmenu)
        }

        //funcion ordenar tacos
        val btnordentaco = findViewById<Button>(R.id.button_ordenar_taco)
        btnordentaco.setOnClickListener {
            //base de datos
            val admin =  AdminSQliteOpenHelper(this, name = "administracion",factory = null, version = 1)
            val bd = admin.writableDatabase
            val registro= ContentValues()
            registro.put("producto",orden_de_tacos.getText().toString())
            registro.put("precio",precio.getText().toString())
            bd.insert("productos",null,registro)
            bd.close()
            Toast.makeText(this,"Se cargaron los datos del articulo",Toast.LENGTH_SHORT).show()

            val ordentacos = Intent(this,compra::class.java)
            startActivity(ordentacos)



        }

        //funcion llevar a compra combo familiar
        val btnFamiliar  = findViewById<Button>(R.id.buttonFamiliar)
        btnFamiliar.setOnClickListener {
            val ordenFamiliar =Intent(this,compra::class.java)
            startActivity(ordenFamiliar)
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
                Toast.makeText(this,"No tengo funcion papu",Toast.LENGTH_SHORT).show()
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