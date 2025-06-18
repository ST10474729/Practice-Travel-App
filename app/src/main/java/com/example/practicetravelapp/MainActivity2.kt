package com.example.practicetravelapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)

            // These are array lists where we store each packing item's details
             val items = arrayListOf<String>()       // Stores the names of items.
             val categories = arrayListOf<String>()  // Stores the category of each item.
             val quantities = arrayListOf<Int>()     // Stores the quantity of each item.
             val comments = arrayListOf<String>()    // Stores the comment of each item.

            @RequiresApi(Build.VERSION_CODES.S)
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_main2)

                // Linking UI elements
                // Input field for the items name (e.g toothbrush)
                val itemInput = findViewById<EditText>(R.id.inputItem)

                // Input field for category (e.g.toiletries)
                val categoryInput = findViewById<EditText>(R.id.categoryInput)

                // Input field for how many of that item
                val quantityInput = findViewById<EditText>(R.id.inputQuantity)

                // Optional Comment (e,g "Use for hotel only)
                val commentsInput = findViewById<EditText>(R.id.inputComments)

                // Button to add items to list
                val addBtn = findViewById<Button>(R.id.btnAdd)

                // Button to view items on list
                val viewBtn = findViewById<Button>(R.id.btnView)

                //Button to completely exit the app
                val exitBtn = findViewById<Button>(R.id.btnExit)



                // When the user clicks the "Input Item" button, this block of code will
                addBtn.setOnClickListener {

                    // Store the user input from each text box into a temporary variable
                    val item = itemInput.text.toString()
                    val category = categoryInput.text.toString()
                    val quantityText = quantityInput.text.toString()
                    val comment = commentsInput.text.toString()

                    // Validate input fields
                    if (item.isBlank() || category.isBlank() || quantityText.isBlank() || comment.isBlank()) {
                        Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT)
                            .show()
                        return@setOnClickListener
                    }

                    val quantity = quantityText.toIntOrNull()
                    if (quantity == null || quantity <= 0) {
                        Toast.makeText(
                            this,
                            "Quantity must be a positive number!",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@setOnClickListener
                    }

                    // Add data to corresponding lists
                    items.add(item)
                    categories.add(category)
                    quantities.add(quantity)
                    comments.add(comment)

                    Toast.makeText(this, "Item added successfully!", Toast.LENGTH_SHORT).show()

                    // Clear input fields
                    itemInput.text.clear()
                    categoryInput.text.clear()
                    quantityInput.text.clear()
                    commentsInput.text.clear()

                }


                // "Display" button click listener
                viewBtn.setOnClickListener {
                    val intent = Intent(this, MainActivity3::class.java)

                    // Attach all lists as extras
                    intent.putStringArrayListExtra("items", items)
                    intent.putStringArrayListExtra("categories", categories)
                    intent.putIntegerArrayListExtra("quantities", quantities)
                    intent.putStringArrayListExtra("comments", comments)

                    // Start the display activity
                    startActivity(intent)

                }

                // "Exit" button click listener
                exitBtn.setOnClickListener {
                    finishAffinity() // Closes the app completely
                }

        }
    }
