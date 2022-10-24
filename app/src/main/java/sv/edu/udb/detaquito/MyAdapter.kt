package sv.edu.udb.detaquito
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val userList :ArrayList<Producto>) :RecyclerView.Adapter <MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem= userList[position]
        holder.name.text =currentitem.name
        holder.precio.text=currentitem.precio
        holder.keysi.text=currentitem.key

    }

    override fun getItemCount(): Int {
       return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val  name: TextView =itemView.findViewById(R.id.Producto)
       val  precio : TextView=itemView.findViewById(R.id.tvtprecio)
       val   keysi  : TextView= itemView.findViewById(R.id.tvtkeys)

    }


}