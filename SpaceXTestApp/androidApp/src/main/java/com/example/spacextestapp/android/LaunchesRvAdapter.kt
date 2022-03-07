package com.example.spacextestapp.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spacextestapp.entity.RocketLaunch

class LaunchesRvAdapter(var launches: List<RocketLaunch>) : RecyclerView.Adapter<LaunchesRvAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
            .run(::LaunchViewHolder)
    }

    override fun getItemCount(): Int = launches.count()

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(launches[position])
    }

    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ...

        fun bindData(launch: RocketLaunch) {
            val missionName = itemView.findViewById<TextView>(R.id.missionName)
            val launchSuccess = itemView.findViewById<TextView>(R.id.launchSuccess)
            val launchYear = itemView.findViewById<TextView>(R.id.launchYear)
            val details = itemView.findViewById<TextView>(R.id.details)

            missionName.text = launch.missionName
            launchSuccess.text = launch.launchSuccess?.let { "Success" } ?: "Fail"
            launchYear.text = launch.launchYear.toString()
            details.text = launch.details
        }
    }
}