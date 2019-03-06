package com.nanocomputing.bettips

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nanocomputing.bettips.models.tips
import kotlinx.android.synthetic.main.tips_item.view.*
import java.text.SimpleDateFormat


class tipsAdapter(val items:List<tips>,
                  val context: Context):RecyclerView.Adapter<TheViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {

        return TheViewHolder(LayoutInflater.from(context)
                .inflate(
                        R.layout.tip_items,
                        parent,
                        false));
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        val formatter = SimpleDateFormat("E, MMM dd yyyy")
        holder?.time?.text = items.get(position).time
        holder?.teams?.text = items.get(position).teamA+" vs "+items.get(position).teamB
        holder?.teamAOdds?.text = items.get(position).oddsA
        holder?.teamBOdds?.text = items.get(position).oddsB
        holder?.teamA?.text = items.get(position).teamA
        holder?.teamB?.text = items.get(position).teamB


    }
    override fun getItemCount(): Int {
        return items.size

    }
}
class ViewHolder(view: View):RecyclerView.ViewHolder(view)
{
    val view = view
    val time = view.time
    val teams = view.teams
    val teamA = view.teamA
    val teamB = view.teamB
    val teamAOdds = view.teamAOdds
    val teamBOdds = view.teamBOdds

}