package com.mobile.azrinurvani.footballleague

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(private val items:List<LeagueItem>, private val listener:(LeagueItem)->Unit)
    :RecyclerView.Adapter<LeagueAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LeagueUI().createView(
        AnkoContext.Companion.create(parent.context,parent)))

    override fun getItemCount()= items.size

    override fun onBindViewHolder(holder: LeagueAdapter.ViewHolder, i: Int) {
        holder.bindItem(items[i],listener)
    }

    class ViewHolder(override val containerView: View):RecyclerView.ViewHolder(containerView),LayoutContainer {
        val image = itemView.findViewById<ImageView>(LeagueUI.league_image)
        val name = itemView.findViewById<TextView>(LeagueUI.league_name)

        fun bindItem(items: LeagueItem, listener: (LeagueItem) -> Unit){
            name.text = items.name

            items.image?.let {
                Picasso.get().load(it).into(image)
            }

            itemView.setOnClickListener{
                listener(items)
            }
        }

    }
}
