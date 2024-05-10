package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomePage : AppCompatActivity() {

    lateinit var reminderBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        findViews()

        reminderBtn.setOnClickListener{
            openReminderPage()
        }
    }

    private fun findViews() {
        reminderBtn = findViewById(R.id.main_BTN_reminder)
    }

    private fun openReminderPage() {
//        public Intent(     android.content.Context packageContext,
//    Class<?> cls )
        var packageContext: android.content.Context = this
        var cls: Class<ReminderActivity> = ReminderActivity::class.java

        // Explicit Intent
        var i = Intent(packageContext, cls)

        startActivity(i)
    }
}