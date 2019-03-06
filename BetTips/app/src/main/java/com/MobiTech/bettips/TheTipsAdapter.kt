package com.nanocomputing.bettips

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nanocomputing.bettips.models.tips
import kotlinx.android.synthetic.main.each_tips_item.view.*
import java.text.SimpleDateFormat


class TheTipsAdapter(val items:List<tips>,
                  val context: Context):RecyclerView.Adapter<TheViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {

        return TheViewHolder(LayoutInflater.from(context)
                .inflate(
                        R.layout.each_tips_item,
                        parent,
                        false));
    }

    override fun onBindViewHolder(holderThe: TheViewHolder, position: Int) {
        val formatter = SimpleDateFormat("E, MMM dd yyyy")
        holderThe?.time?.text = items.get(position).time
        holderThe?.teams?.text = items.get(position).teamA+" vs "+items.get(position).teamB
        holderThe?.teamAOdds?.text = items.get(position).oddsA
        holderThe?.teamBOdds?.text = items.get(position).oddsB
        holderThe?.teamA?.text = items.get(position).teamA
        holderThe?.teamB?.text = items.get(position).teamB
        holderThe?.numberofItem?.text = (position+1).toString()+". "
        holderThe?.bt_save.setOnClickListener {
            Toast.makeText(context, "You have saved this game", Toast.LENGTH_SHORT).show()


        }


    }
    override fun getItemCount(): Int {
        return items.size

    }
}
class TheViewHolder(view: View):RecyclerView.ViewHolder(view)
{
    val view = view
    val time = view.time
    val teams = view.teams
    val teamA = view.teamA
    val teamB = view.teamB
    val teamAOdds = view.teamAOdds
    val teamBOdds = view.teamBOdds
    val numberofItem = view.number
    val bt_save = view.bt_save

}