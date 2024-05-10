package com.example.finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class MyCustomAdapter(private val context: Context, private val players:List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        // Return the number of items  (players) in the data set
        return players.size
    }

    override fun getItem(position: Int): Any {
        // Return the data item (player) associated with the specified position in the data set
        return players[position]
    }

    override fun getItemId(position: Int): Long {
        // Return a unique identifier for the item (player) at the specified position
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View
        if (convertView == null){
            // inflate a new view using layout inflater
            view = inflater.inflate(R.layout.my_custom_layout_testing, parent, false)
        }else {
            // If convertView is not Null, REUSE IT
            view = convertView
        }

        // Bind the data to the view:
        val player = getItem(position) as String
        val titleTextView = view.findViewById<TextView>(R.id.playerTextViewCustom)
        val btn = view.findViewById<Button>(R.id.playerButtonViewCustom)

        titleTextView.text = player
        btn.text = player

        return view
    }
}