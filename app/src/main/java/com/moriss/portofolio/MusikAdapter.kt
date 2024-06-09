package com.moriss.portofolio
//<!--Fauzan Fadhil Moricio-->
//<!--10121077-->
//<!--IF2_PemAndro3-->
//<!--27 Mei 2024-->
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusikAdapter(private val context: Context, private val musikList: List<Musik>) : RecyclerView.Adapter<MusikAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val musikImage: ImageView = itemView.findViewById(R.id.musikImage)
        val judul: TextView = itemView.findViewById(R.id.judul)
        val artist: TextView = itemView.findViewById(R.id.artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_musik, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = musikList[position]
        holder.musikImage.setImageResource(currentItem.imageResId)
        holder.judul.text = currentItem.judul
        holder.artist.text = currentItem.artist

        holder.artist.setOnClickListener {
            val url = currentItem.url

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return musikList.size
    }
}
