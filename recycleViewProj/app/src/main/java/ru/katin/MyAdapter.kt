package ru.katin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.katin.databinding.LayoutCardviewBinding

class MyAdapter(private val list: MutableList<Person>) : RecyclerView.Adapter<MyAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(private val binding: LayoutCardviewBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.tv.text = person.name
            binding.imgView.setImageResource(person.avatarId)

            binding.btnPress.setOnClickListener{
                Toast.makeText(it.context, "Hi student ${person.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.PersonViewHolder {
        val binding = LayoutCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(list[position])
    }
}