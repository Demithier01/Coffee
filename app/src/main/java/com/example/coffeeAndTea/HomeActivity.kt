package com.example.coffeeAndTea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeAndTea.model.Coffee
import com.example.coffeeAndTea.model.Popular
import com.example.coffee_and_tea.R
import java.util.Locale

class HomeActivity : AppCompatActivity() {
    private lateinit var coffeeRecyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private  var cflist = ArrayList<Coffee>()
    private lateinit var coffeeadapter: CoffeeAdapter

    private lateinit var popularRecyclerView: RecyclerView
    private lateinit var popularadapter: PopularAdapter
    private var mList = ArrayList<Popular>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        coffeeRecyclerView = findViewById(R.id.recycerview)
        searchView = findViewById(R.id.searchView)
        popularRecyclerView = findViewById(R.id.recycerview2)

        coffeeRecyclerView.setHasFixedSize(true)
        coffeeRecyclerView.layoutManager = LinearLayoutManager(this,)
        addDataTolist()
        coffeeadapter = CoffeeAdapter(cflist)
        coffeeRecyclerView.adapter = coffeeadapter

        popularRecyclerView.setHasFixedSize(true)
        popularRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        popularadapter = PopularAdapter(mList)
        popularRecyclerView.adapter = popularadapter

        popularListData()



        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<Coffee>()
            for (i in cflist) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                coffeeadapter.setFilteredList(filteredList)
            }
        }
    }
    private fun addDataTolist(){
        cflist.add(Coffee("Americano" , R.drawable.americano))
        cflist.add(Coffee("Coco" , R.drawable.coco))
        cflist.add(Coffee("Espresso" , R.drawable.espresso))
        cflist.add(Coffee("GreenTea" , R.drawable.greentea))
        cflist.add(Coffee("ThaiTea" , R.drawable.thaitea))
    }
    private fun popularListData(){
        mList.add(Popular("ThaiTea", R.drawable.thaitea))
        mList.add(Popular("Waffle Ice Cream", R.drawable.waffle_ice_cream))
        mList.add(Popular("Americano", R.drawable.americano))
        mList.add(Popular("Macaron", R.drawable.macaron))
        mList.add(Popular("Coco", R.drawable.coco))
    }
}