package com.example.practicetravelapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

            //Declaring the screen elements
            private lateinit var txtShowsItems: TextView
            private lateinit var txtItemsQuantity: TextView
            private lateinit var btnMainMenu: Button
            private lateinit var btnShowsItems: Button
            private lateinit var btnItemsQuantity: Button


            @SuppressLint("MissingInflatedId")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_main3)

                //Link each Kotlin variable to its matching view in the layout using its ID
                txtShowsItems = findViewById(R.id.txtShowItems)
                txtItemsQuantity = findViewById(R.id.txtItemsQuantity)
                btnMainMenu = findViewById(R.id.btnMainMenu)
                btnShowsItems = findViewById(R.id.btnShowItems)
                btnItemsQuantity = findViewById(R.id.btnItemsQuantity)

                //Recieve the packing list passed from the other screen
                val items = intent.getStringArrayListExtra("items") ?: arrayListOf()
                val categories = intent.getStringArrayListExtra("categories") ?: arrayListOf()
                val quantities = intent.getStringArrayListExtra("quantities") ?: arrayListOf()
                val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

                //when the user clicks the "show all" button, build a full list of items
                findViewById<Button>(R.id.btnShowItems).setOnClickListener {
                    val list = items.indices.joinToString("\n") {
                        //Create a string
                        "${items[it]} (${categories[it]}) - ${quantities[it]}: ${comments[it]}"
                    }
                    //Display a message if the list is empty
                    btnShowsItems.text = list.ifBlank { "No items added!" }
                }

                //When the user clicks the filter button, show items with the quantity 2 or more
                findViewById<Button>(R.id.btnItemsQuantity).setOnClickListener {
                    val filtered = items.indices
                        .filter { quantities[it] >= 2.toString() }
                        .joinToString("\n") {
                            //Only show the item name and quantity
                            "${items[it]} (Qty: ${quantities[it]})"
                        }
                    //Show filtered list or display a message if no items match
                    btnItemsQuantity.text = filtered.ifBlank { "No items with the quantity 2 or more" }
                }

                //When the user clicks the back button return to the main menu
                findViewById<Button>(R.id.btnMainMenu).setOnClickListener {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                }

        }
    }
