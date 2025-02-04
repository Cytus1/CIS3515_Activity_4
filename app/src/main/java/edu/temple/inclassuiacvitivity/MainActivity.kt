package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        //val numberArray = Array Of Numbers

        // val numberArray = arrayOf(1, 2, 3)   val strings: Array<String> = arrayOf("Kotlin", "Java", "Python")
        // val numbers = Array(5) { i -> i * 5 }    println(numbers.joinToString()) // Outputs: 0, 5, 10, 15, 20

        val numberArray = (5..100 step 5).toList()

        /* TODO Step 3: Create adapter to display items from array in Spinner */
        //spinner.adapter = ArrayAdapter...

//        ArrayAdapter(
//            context: Context,       // Activity or other Context
//            resource: Int,          // Layout resource for each item (e.g., android.R.layout.simple_list_item_1)
//            objects: List<T>        // The data list or array
//        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            numberArray
        )

        spinner.adapter = adapter


        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        //spinner.onItemSelectedListener = object: ...

//        https://developer.android.com/reference/android/widget/AdapterView.OnItemSelectedListener
//        public abstract void onItemSelected (AdapterView<?> parent,
    //        View view,
    //        int position,
    //        long id)

//        onNothingSelected public abstract void onNothingSelected (AdapterView<?> parent)

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                )

                {
                    displayTextView.textSize = numberArray.get(position).toFloat()
                }

                override fun onNothingSelected(parent: AdapterView<*>) { }

            }

    }
}