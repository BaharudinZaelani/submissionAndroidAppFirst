package com.bahardev.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<HeroIndonesia>()

    private fun constructor() {
        rvHeroes = findViewById(R.id.rvHeroes)
        rvHeroes.setHasFixedSize(true)
        list.addAll(getListHeroIndonesia())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constructor()
        showRecyclerList()
    }

    private fun showSelectedItem(hero: HeroIndonesia) {

        val aboutPage = Intent(this@MainActivity, AboutHero::class.java)
        aboutPage.putExtra("photo", hero.photo)
        aboutPage.putExtra("name", hero.name)
        aboutPage.putExtra("description", hero.description)
        startActivity(aboutPage)
    }

    private fun getListHeroIndonesia(): ArrayList<HeroIndonesia> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<HeroIndonesia>()
        for (i in dataName.indices) {
            val hero = HeroIndonesia(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HeroIndonesia) {
                showSelectedItem(data)
            }
        })
    }

    // Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when ( item.itemId ){
            R.id.aboutMe -> {
                val aboutMePage = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(aboutMePage)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}