package com.dbRecords

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dbRecords.R.layout
import org.jetbrains.anko.doAsync
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var btn: Button
    private lateinit var model: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        btn = findViewById(R.id.btn)
        /* Get the view model */
        val modelFactory = UserViewModelFactory(application)

        model = ViewModelProvider(this, modelFactory).get(UserViewModel::class.java)

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )
        recyclerView.layoutManager = linearLayoutManager

        // Observe the model
        model.allUsers.observe(this) { students ->
            // Data bind the recycler view
            recyclerView.adapter = RecyclerViewAdapter(students)
        }

        // Insert data into table
        btn.setOnClickListener {
            doAsync {
                model.insert(User(null, UUID.randomUUID().toString()))
            }
        }
    }
}