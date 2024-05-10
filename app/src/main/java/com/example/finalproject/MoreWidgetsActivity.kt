package com.example.finalproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi

class MoreWidgetsActivity : AppCompatActivity() {
    lateinit var checkBox1: CheckBox
    lateinit var tivTaamVoucherOptions: RadioGroup
    lateinit var tivtaam30: RadioButton
    lateinit var tivtaam50: RadioButton

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_widgets)

        findViews()

        // Checkbox
        displayCheckBox()

        // Radio Button
        displayRadioGroup()

        // Spinner
        displaySpinner()

        // Time picker
        displayTimePicker()

        // Date Picker
        displayDatePicker()

        // ListView
        displayListView()
    }

    /* Date Picker: allows users to selects a date */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun displayDatePicker() {
//        val datePicker: DatePicker = findViewById<DatePicker>(R.id.myDatePicker)
//
//
//        var handleDateChages:(DatePicker, Int, Int, Int) -> Unit = {_, year, month, day ->
//            var formattedDate: String = String.format("%02d/%02d/%4d", day, month+1, year)
//            Toast.makeText(applicationContext, "Date: $formattedDate", Toast.LENGTH_SHORT).show()
//        }
//
//        datePicker.setOnDateChangedListener(handleDateChages)

    }

    private fun displayTimePicker() {
//        val myTimePicker: TimePicker = findViewById(R.id.myTimePicker)
//
//        // Set the TimePicker to display a 24-hour clock
//        myTimePicker.setIs24HourView(true)
//
//        // Handle the changes in time:
//        var handleChanges: (TimePicker, Int, Int) -> Unit = {_, hoursOfDay, minute ->
//            // Formatting the selected time:
//            val selectedTime: String = String.format("%02d:%02d", hoursOfDay, minute)
//
//            Toast.makeText(applicationContext, "Your Time: $selectedTime", Toast.LENGTH_SHORT).show()
//        }
//
//        myTimePicker.setOnTimeChangedListener(handleChanges)

    }

    private fun displayListView() {
        // 1. Init the spinner view
        val listView: ListView = findViewById(R.id.myListView)

        // 2. Data source for the ListView (Array)
        val vouchers: Array<String> =
            arrayOf("Shufersal 30 NIS Voucher", "Shufersal 50 NIS Voucher", "TivTaam 30 NIS Voucher")

        // ArrayAdapter(          context: android.content.Context,      resource: Int,        objects: T[])       -->       ArrayAdapter<T>
        val myAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, vouchers)

        // Set the adapter to a view
        listView.adapter = myAdapter

    }

    private fun displaySpinner() {
        // Init the spinner view
        val spinner: Spinner = findViewById(R.id.mySpinner)

        // Data source for the spinner (Array)
        val vouchers: Array<String> = arrayOf("Shufersal 30 NIS", "Shufersal 50 NIS", "TivTaam 30 NIS")

        // ArrayAdapter(context: android.content.Context, resource: Int, objects: T[]) --> ArrayAdapter<T>
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, vouchers)

        // Set the adapter to a view
        spinner.adapter = adapter

        // Handling the item selection in a spinner:
        // Set an instance of the custom listener class as the listener for the spinner
        val spinnerItemSelectedListener = SpinnerItemSelectedListener(vouchers)
        spinner.onItemSelectedListener = spinnerItemSelectedListener

        // object: anonymous object
//        spinner.onItemSelectedListener = object :
//        AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
//            // Object: serves as the listener for item selection events
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                // Handle the selected item:
//                val selectedItem = vouchers[position]
//
//                //  makeText(android.content.Context context, CharSequence text, int duration ) --> Toast
//                Toast.makeText(applicationContext, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onItemClick(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                TODO("Not yet implemented")
//            }
//        }

    }

    private fun displayRadioGroup() {
        // Unit is similar to void in Java
        var lambda: (_:RadioGroup, resourceID: Int) -> Unit = { _ , resourceID ->
            when(resourceID){
                R.id.tivtaam30 -> {
                    Toast.makeText(this, "Tiv Taam 30 NIS Voucher selected", Toast.LENGTH_SHORT).show()
                }
                R.id.tivtaam50 -> {
                    Toast.makeText(this, "Tiv Taam 50 NIS Voucher selected", Toast.LENGTH_SHORT).show()
                }

            }
        }

        tivTaamVoucherOptions.setOnCheckedChangeListener(lambda)

    }

    private fun displayCheckBox() {
        // Handle checkbox state changes
        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            // Checkbox is checked
            if (isChecked) {
                Toast.makeText(this, "Option1 checked", Toast.LENGTH_SHORT).show()
            } else {
                // Checkbox is unchecked
                Toast.makeText(this, "Option1 unchecked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun findViews() {
        checkBox1 = findViewById(R.id.checkBox1)
        tivTaamVoucherOptions = findViewById(R.id.radioGroup1)
        tivtaam30 = findViewById(R.id.tivtaam30)
        tivtaam50 = findViewById(R.id.tivtaam50)
    }
}

// Define a custom class that implements AdapterView.OnItemSelectedListener
class SpinnerItemSelectedListener(private val vouchers: Array<String>) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Handle the selected item:
        val selectedItem = vouchers[position]
        // Show a toast message with the selected item
        Toast.makeText(parent?.context, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Handle the case where nothing is selected (optional)
        // For example:
        // Toast.makeText(parent?.context, "Nothing selected", Toast.LENGTH_SHORT).show()
    }
}



