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
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Menu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val database = Firebase.database
    private lateinit var  drawer: DrawerLayout
    private lateinit var  toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val toolbar: androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer=findViewById(R.id.drawer_layout)
        val myRef = database.getReference("Producto")
        toogle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        Toast.makeText(this,"Hola beba",Toast.LENGTH_SHORT).show()
        val btncarrito = findViewById<ImageButton>(R.id.btncarritoCompra)
        btncarrito.setOnClickListener {
            Toast.makeText(this,"Prueba de TOAST NOTIFICATION",Toast.LENGTH_SHORT).show()
        }

        //Agregar base datos
        val  agregarComboBurrito =findViewById<Button>(R.id.txtComboB4)
        val  textoComboBurrito = "Combo Burritos"
        val  precio = 7.99


        agregarComboBurrito.setOnClickListener {
            val agregarComboBurrito = Producto(textoComboBurrito.toString(),precio.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarComboBurrito)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }
       //Agregar base dato
        val nacho= findViewById<Button>(R.id.textBotonN)
        val nachotext = "Nacho"
        val precioNacho =3.99
        agregarComboBurrito.setOnClickListener {
            val agregarnacho = Producto(nachotext.toString(),precioNacho.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarnacho)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }

        //Agregar base dato
        val burrito2 =findViewById<Button>(R.id.textBotonB)
        burrito2.setOnClickListener {
            val agregarComboBurrito = Producto(textoComboBurrito.toString(),textoComboBurrito.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarComboBurrito)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }
        //Agregar Combo toras
        val  textBoton = findViewById<Button>(R.id.textBotonC)
        val torta = "Combo tortas"
        val preciotortas = "5.99"
        textBoton.setOnClickListener {
            val agregartorta = Producto(torta.toString(),preciotortas.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregartorta)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }

        //Agregar tacos
        val tacoos =findViewById<Button>(R.id.tacosBoton)
        val taquito = "Tacos"
        val preciotaco ="4.99"
        tacoos.setOnClickListener {
            val agregartaquito = Producto(taquito.toString(),preciotaco.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregartaquito)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }
        //Agregar Coca Cola
        val  coca =  findViewById<Button>(R.id.CocaBoton)
        val  coquita = "Coca Cola"
        val precioCoquita = "1.00"

        coca.setOnClickListener {
            val agregarcoquita = Producto(coquita.toString(),precioCoquita.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarcoquita)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }
        //vaso pepsi
        val pepsi =findViewById<Button>(R.id.BotonPepsi)
        val  pepsii = "Pepsi"
        val preciopepsi = "1.00"

        pepsi.setOnClickListener {
            val agregarpepsi = Producto(pepsii.toString(),preciopepsi.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarpepsi)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }
        //Ron con coca
        val RonCoca =findViewById<Button>(R.id.RonBoton)
        val ron = "Ron Con Coca"
        val precioRon = "2.00"

        RonCoca.setOnClickListener {
            val agregarRon = Producto(ron.toString(),precioRon.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarRon)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }

        //Quesadilla
        val  Quesadilla= findViewById<Button>(R.id.btnQuesadilla)
        val  quesadill ="Quesadilla"
        val precioQuesadilla = "5.00"

        Quesadilla.setOnClickListener {
            val agregarQuesadilla = Producto(quesadill.toString(),precioQuesadilla.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarQuesadilla)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
        }
        //Cerveza
        val cerveza = findViewById<Button>(R.id.btnBaldeC)
        val cervesa = "Cervezas"
        val balde = "12.00"

        cerveza.setOnClickListener {
            val agregarCerveza = Producto(cervesa.toString(),balde.toString())
            myRef.child(myRef.push().key.toString()).setValue(agregarCerveza)
            //finish()
            Toast.makeText(this,"Se agrego al carrito",Toast.LENGTH_SHORT).show()
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
                val comprita = Intent(this,comprita::class.java)
                startActivity(comprita)

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
