package ru.katin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ru.katin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter
    private val people: MutableList<Person> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        people.add(Person("Petia", R.drawable.img1))
        people.add(Person("Sergey", R.drawable.img2))
        people.add(Person("Igor", R.drawable.img3))
        people.add(Person("Nikolay", R.drawable.img4))

        binding.recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager

        val newAdapter = MyAdapter(people)
        adapter = newAdapter
        binding.recyclerView.adapter = newAdapter

        binding.btnClear.setOnClickListener {
            val count = people.size
            people.clear()
            adapter.notifyItemRangeRemoved(0, count)
        }
        binding.btnDelete.setOnClickListener {
            if (people.isNotEmpty()) {
                people.removeAt(people.size - 1)
                adapter.notifyItemRemoved(people.size)
            }
        }
        binding.btnAdd.setOnClickListener {
            people.add(Person("New Student", R.drawable.img4))
            adapter.notifyItemInserted(people.size - 1)
        }
    }
}