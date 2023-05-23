package com.example.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun generateFibonacciNumbers(): List<Int> {
        val fibonacciNumbers = mutableListOf(0, 1)

        for (i in 2 until 100) {
            val sum = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2]
            fibonacciNumbers.add(sum)
        }

        return fibonacciNumbers
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )

        val fibonacciNumbers = generateFibonacciNumbers()
        val adapter = FibonacciAdapter(fibonacciNumbers)

        recyclerView.adapter = adapter
    }
}
