package com.pushpo.medalcaseapp.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pushpo.medalcaseapp.Model.Medal_Items
import com.pushpo.medalcaseapp.R

/**
 * This Adapter class generates item data of Medals inside Achievement Adapter
 * @param mValues
 */
class MedalListAdapter (var mValues: ArrayList<Medal_Items>) : RecyclerView.Adapter<MedalListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_medal_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mItem = mValues[position]
        if (mItem.itemName.length > 0) holder.tvName.text = mItem.itemName
        if (mItem.itemValue.length > 0) holder.tvValue.text = mItem.itemValue

        holder.imgView.setImageResource(mItem.image)
        if (mItem.itemValue.equals("not yet", true)) {
            holder.shadowView.visibility = View.VISIBLE
            val params: ViewGroup.LayoutParams = holder.shadowView.getLayoutParams()
            //params.height = holder.linearView.height
            params.height = 350
            holder.shadowView.setLayoutParams(params)
        }else{
            holder.shadowView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val tvName: TextView
        internal val tvValue: TextView
        internal val imgView: ImageView
        internal val shadowView: View
        internal val linearView: LinearLayout

        init {
            tvName = itemView.findViewById(R.id.item_Name)
            tvValue = itemView.findViewById(R.id.item_value)
            imgView = itemView.findViewById(R.id.item_image)
            shadowView = itemView.findViewById(R.id.shadow_view)
            linearView = itemView.findViewById(R.id.itemVIew)
        }
    }
}