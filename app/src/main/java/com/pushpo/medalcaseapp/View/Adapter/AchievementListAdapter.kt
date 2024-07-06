package com.pushpo.medalcaseapp.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pushpo.medalcaseapp.Model.AchievementsItem
import com.pushpo.medalcaseapp.R

/**
 * This Adapter class generates item data of Achievements including medal data
 * @param mValues
 */
class AchievementListAdapter (var mValues: ArrayList<AchievementsItem>) : RecyclerView.Adapter<AchievementListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_achievements_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mItem = mValues[position]

        if (mItem.title.length > 0) holder.tvTitle.text = mItem.title
        if (mItem.titleValue.length > 0) holder.tvValue.text = mItem.titleValue

        if (mItem.itemsList.size > 0){
            holder.listView.setAdapter(MedalListAdapter(mItem.itemsList))
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val tvTitle: TextView
        internal val tvValue: TextView
        internal val listView: RecyclerView
        init {
            tvTitle = itemView.findViewById(R.id.item_title)
            tvValue = itemView.findViewById(R.id.title_value)
            listView = itemView.findViewById(R.id.list_medal_items)

        }
    }
}