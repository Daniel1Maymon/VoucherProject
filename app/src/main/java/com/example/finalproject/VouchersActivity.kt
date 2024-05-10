package com.example.finalproject

import VoucherAdapter
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class VouchersActivity : AppCompatActivity() {
    lateinit var myListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vouchers)

        // 1- Initiate the list view
        findViews()

        // 2- Create the data source: List<Voucher>
        val voucher30 = Voucher("Shufersal", "30", R.drawable.a)
        val voucher50 = Voucher("Shufersal", "50", R.drawable.b)

        var voucherList = ArrayList<Voucher>()
        voucherList.add(voucher30)
        voucherList.add(voucher50)


        // 3 - Adapter:
        val voucherAdapter = VoucherAdapter(this, voucherList)

        // 4. Set the adapter to the listView
        myListView.adapter = voucherAdapter
    }

    private fun findViews() {
        myListView = findViewById(R.id.myListView)
    }
}