package com.bahardev.submission

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutHero: AppCompatActivity() {
    private lateinit var componentName: TextView
    private lateinit var componentPhoto: ImageView
    private lateinit var componentDescription: TextView

    private fun constructor() {
        // component
        componentName = findViewById(R.id.hero_name)
        componentDescription = findViewById(R.id.hero_description)
        componentPhoto = findViewById(R.id.hero_photo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_hero)

        constructor()
        componentPhoto.setImageResource(intent.getIntExtra("photo", 0))
        componentDescription.text = intent.getStringExtra("description").toString()
        componentName.text = intent.getStringExtra("name").toString()

        Log.i("ZAW", intent.getIntExtra("photo", 0).toString())
    }
}
