package com.fmi.app

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import java.util.*


class MainActivity : AppCompatActivity(), LocationAdapter.OnNoteListener {
     var camera_open_id: Button? = null
     var animation_id: Button? = null
    /* ImageView click_image_id;*/
    var drawerLayout: DrawerLayout? = null
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null

    var locationRV: RecyclerView? = null
    var adapter: LocationAdapter? = null
    var locationModalArrayList: java.util.ArrayList<LocationModal>? = null
    var someActivityResultLauncher = registerForActivityResult(
        StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val photo = data!!.extras!!["data"] as Bitmap?
            /*click_image_id.setImageBitmap(photo);*/
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //camera
        camera_open_id = findViewById<View>(R.id.camera_button) as Button


        camera_open_id!!.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            someActivityResultLauncher.launch(camera_intent)
        }
        //animation
        animation_id = findViewById<View>(R.id.animation_button) as Button
        animation_id!!.setOnClickListener {
            val animation_intent = Intent(this, AnimationActivity::class.java)
            startActivity(animation_intent)
        }

        drawerLayout = findViewById(R.id.my_drawer_layout)



        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        with(drawerLayout) { this?.addDrawerListener(actionBarDrawerToggle!!) }
        actionBarDrawerToggle!!.syncState()



        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        locationRV = findViewById(R.id.idRVLocations)
        buildRecyclerView()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.actionSearch)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
    private fun filter(text: String) {
        val filteredlist = java.util.ArrayList<LocationModal>()
        for (item in locationModalArrayList!!) {
            if (item.locationName.lowercase().contains(text.lowercase(Locale.getDefault()))) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "No location with this name...", Toast.LENGTH_SHORT).show()
        } else {
            adapter!!.filterList(filteredlist)
        }
    }
    private fun buildRecyclerView() {
        locationModalArrayList = ArrayList<LocationModal>()
        locationModalArrayList!!.add(LocationModal("Spain", "Come to visit Spain."))
        locationModalArrayList!!.add(LocationModal("France", "Come to visit France."))
        locationModalArrayList!!.add(LocationModal("Turkey", "Come to visit Turkey."))
        locationModalArrayList!!.add(LocationModal("Japan", "Come to visit Japan."))
        locationModalArrayList!!.add(LocationModal("Greece", "Come to visit Greece."))
        adapter = LocationAdapter(locationModalArrayList!!, this@MainActivity, this)
        val manager = LinearLayoutManager(this)
        locationRV!!.setHasFixedSize(true)
        locationRV!!.layoutManager = manager
        locationRV!!.adapter = adapter
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle!!.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            R.id.share_button -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = "Turkey, France, Spain, Greece, Japan"
                val shareSubject = "Check out this awesome list with locations to visit!"
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
                startActivity(Intent.createChooser(sharingIntent, "Share using"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNoteClick(position: Int) {
        locationModalArrayList!![position]
        val intent = Intent(this, GalleryActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

}