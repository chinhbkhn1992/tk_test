package tiki.example.chinh.tikitest.presentation.main

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import tiki.example.chinh.tikitest.databinding.ItemKeywordsBinding
import java.util.*

class KeywordAdapter : RecyclerView.Adapter<KeywordViewHolder>() {
    val listKeywords = ObservableArrayList<String>()
    fun updateList(keywords: List<String>) {
        listKeywords.clear()
        listKeywords.addAll(keywords)
    }

    init {
        listKeywords.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<*>>() {
            override fun onChanged(sender: ObservableList<*>) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(sender: ObservableList<*>, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart, itemCount)
            }

            override fun onItemRangeInserted(sender: ObservableList<*>, positionStart: Int, itemCount: Int) {
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onItemRangeMoved(
                sender: ObservableList<*>,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onItemRangeRemoved(sender: ObservableList<*>, positionStart: Int, itemCount: Int) {
                notifyItemRangeRemoved(positionStart, itemCount)
            }
        })
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): KeywordViewHolder {
        val binding = ItemKeywordsBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return KeywordViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listKeywords.size
    }

    override fun onBindViewHolder(p0: KeywordViewHolder, p1: Int) {
        p0.binding.key = listKeywords[p1]
    }

}

class KeywordViewHolder(val binding: ItemKeywordsBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        binding.tv.setBackgroundColor(color)

    }
}