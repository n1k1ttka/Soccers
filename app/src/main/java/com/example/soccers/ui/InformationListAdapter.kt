package com.example.soccers.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccers.R
import com.example.soccers.databinding.InformationItemBinding
import com.example.soccers.network.model.Response
import com.example.soccers.utils.datefromUnix
import com.example.soccers.utils.gameScore

class InformationListAdapter: RecyclerView.Adapter<InformationListAdapter.InformationViewHolder>(){

    private val items = mutableListOf<Response>()

    fun replaceItems(newItems: List<Response>?){
        items.clear()
        if (newItems != null) {
            items.addAll(newItems)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InformationViewHolder {
        return InformationViewHolder( // ViewHolder с раздутым макетом внутри
            LayoutInflater.from(parent.context).inflate(R.layout.information_item, parent, false)
            // Используется LayoutInflater из нашего родительского ViewGroup (recyclerView)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(
        holder: InformationViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class InformationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var binding = InformationItemBinding.bind(itemView)

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(item: Response){
            with(binding){
                this.fixtureDate.text = datefromUnix(item.fixture?.timestamp)
                "${item.goals?.home ?: 0} - ${item.goals?.away ?: 0}".also { this.state.text = it }
                Glide.with(this.label1).load(item.teams?.home?.logo).into(this.label1)
                this.team1.text = item.teams?.home?.name
                Glide.with(this.label2).load(item.teams?.away?.logo).into(this.label2)
                this.team2.text = item.teams?.away?.name
                this.time.text = when {
                    item.fixture?.periods?.second != null -> {
                        gameScore(System.currentTimeMillis()/1000, item.fixture.periods.second, "второй")
                    }
                    item.fixture?.periods?.first != null -> {
                        gameScore(System.currentTimeMillis()/1000, item.fixture.periods.first, "первый")
                    }
                    else -> { "Not started" }
                }
            }
        }
    }
}