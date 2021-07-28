package com.example.expandablelistview

import Adapters.ExpandableAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var map: HashMap<String, List<String>>
    lateinit var titleList: ArrayList<String>
    lateinit var expandableAdapter: ExpandableAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        titleList = ArrayList()
        map = HashMap()
        titleList.add("Codial 2-3")
        titleList.add("Codial 4")
        titleList.add("Codial 5")

        map[titleList[0]] = listOf("Darxonbek", "MuhammadUmar", "Jahongir")
        map[titleList[1]] = listOf("MuhammadAzim", "Bahodir", "Ibrohimjon")
        map[titleList[2]] = listOf("va boshqalar")



        expandableAdapter = ExpandableAdapter(titleList, map)
        expanded_menu.setAdapter(expandableAdapter)

        expanded_menu.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(this, "${map[titleList[groupPosition]?.get(childPosition)]}", Toast.LENGTH_SHORT).show()
            true
        }

    }
}