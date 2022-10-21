package sv.edu.udb.detaquito
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class AdminSQliteOpenHelper(context: Context,name:String,factory:CursorFactory?, version :Int):SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table productos(producto text,precio real)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldversion:Int,newVersion: Int) {

    }
}