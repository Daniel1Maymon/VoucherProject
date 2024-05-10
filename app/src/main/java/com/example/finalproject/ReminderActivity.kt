package com.example.finalproject

import android.Manifest
import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ReminderActivity : AppCompatActivity() {
    lateinit var reminderDateText: TextView
    lateinit var reminderTimeText: TextView
    lateinit var selectDateButton: Button
    lateinit var selectTimeButton: Button
    lateinit var testButton: Button
    lateinit var saveButton: Button
    lateinit var deleteTimeButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder)
        findViews()

        selectDateButton.setOnClickListener{
            showDatePickerDialog()
        }

        selectTimeButton.setOnClickListener {
            showTimePickerDialog()
        }


    }

    private fun showTimePickerDialog() {
        // retrieves the current hour and minute from the system time using a Calendar instance
        val calendar = Calendar.getInstance()
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)


        // Create TimePickerDialog object
        val timePickerDialog: TimePickerDialog = TimePickerDialog(
            this,
            timeSetListener,
            currentHour,
            currentMinute,
            true)

        timePickerDialog.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        // Pass the declared function as an argument to DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            this,
            dateSetListener, // Pass the declared function reference here
            currentYear,
            currentMonth,
            currentDay
        )

        datePickerDialog.show()
    }


    private val timeSetListener = TimePickerDialog.OnTimeSetListener {_, hourOfDay, minute ->
        println("::: timeSetListener :: START")
        // Update the TextView with the selected time:
        val selectedTime: Calendar = Calendar.getInstance()
        selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
        selectedTime.set(Calendar.MINUTE, minute)

        val timeFormat: SimpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val timeString = timeFormat.format(selectedTime.time)


        reminderTimeText.text = "Reminder Time: $timeString"
        println("::: timeSetListener :: END")
    }


    // Declared function for handling date selection
    private val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        // Update the TextView with the selected date
        val selectedDate = Calendar.getInstance()
        selectedDate.set(year, month, dayOfMonth)

        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateString = dateFormat.format(selectedDate.time)

        reminderDateText.text = "Reminder Date: $dateString"
    }

    private fun findViews() {
        reminderDateText = findViewById(R.id.reminderDate)
        reminderTimeText = findViewById(R.id.reminderTime)
        selectDateButton = findViewById(R.id.BTN_dateSelected)
        selectTimeButton = findViewById(R.id.BTN_TimeSelected)
        testButton = findViewById(R.id.test_BTN)
        saveButton = findViewById(R.id.save_BTN)
        deleteTimeButton = findViewById(R.id.delete_BTN)
    }
}