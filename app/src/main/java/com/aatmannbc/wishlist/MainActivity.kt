package com.aatmannbc.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvWishItems.adapter = todoAdapter
        rvWishItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etWishTitle.text.toString()
            val todoUrl = etUrl.text.toString()
            val todoPrice = etPrice.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle,false,todoPrice,todoUrl)
                todoAdapter.addTodo(todo)
                etWishTitle.text.clear()
                etUrl.text.clear()
                etPrice.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}