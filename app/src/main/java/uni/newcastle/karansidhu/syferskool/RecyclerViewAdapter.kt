package uni.newcastle.karansidhu.syferskool

import android.support.v7.widget.RecyclerView
import android.view.View
import uni.newcastle.karansidhu.syferskool.RecyclerViewAdapter.ViewHolder
import android.view.ViewGroup
import android.widget.*
import android.content.Context
import android.view.LayoutInflater

/**
 * Created by Karan Sidhu on 08/05/2018.
 */
class RecyclerViewAdapter(val context: Context, val main : ArrayList<String>, val sub : ArrayList<String>) : RecyclerView.Adapter<ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.main.text = main.get(position)
        holder.sub.text = sub.get(position)
    }

    override fun getItemCount(): Int {
        return main.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val main = itemView.findViewById<TextView>(R.id.list_item_main)
        val sub : TextView = itemView.findViewById(R.id.list_item_sub)
        val listLayout : RelativeLayout = itemView.findViewById(R.id.list_layout)
    }
}