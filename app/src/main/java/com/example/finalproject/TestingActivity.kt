package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class TestingActivity : AppCompatActivity() {

    lateinit var myListView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)

        // 1. Initialize the listView
        findViews()

        // 2. Data Source:
        val players = listOf(
            "Nikola Jokić",
            "Jamal Murray",
            "Aaron Gordon",
            "Micheal Porter Junior"
        )

        // 3. Adapter:
        // MyCustomAdapter(private val context: Context, private val players:List<String>)
        val customAdapter = MyCustomAdapter(this, players)

        // 4. Set the adapter to the listView
        myListView.adapter = customAdapter
    }

    private fun findViews() {

        myListView = findViewById(R.id.myListView1)
    }
}