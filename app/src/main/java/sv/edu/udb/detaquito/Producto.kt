package sv.edu.udb.detaquito
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
@IgnoreExtraProperties
data class Producto( val name: String? = null, val precio :String , @Exclude val key: String? = null)
//val url: String? = null