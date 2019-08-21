package org.lox.recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var listStudent: List<Student?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setList()
    }

    fun setList(){
        listStudent = arrayListOf(Student("Carlos", "Hill", 50))
        listStudent = listStudent + Student("Belinda", "Harper", 45)
        listStudent = listStudent + Student("Bertha", "Dunn", 65)
        listStudent = listStudent + Student("Angelina", "Wheeler", 80)

        setupListView(listStudent)
    }

    fun setupListView(list: List<Student?>){
        val adapter = Adapter(this.applicationContext, list)
        val recyclerView: RecyclerView = findViewById(R.id.recycleview_main)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
    }
}