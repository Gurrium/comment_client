package com.example.taira.sendtext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.TextView
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSend_onClick(view:View) {
        val name = findViewById<TextView>(R.id.nameText) as TextView
        val content = findViewById<TextView>(R.id.contentText) as TextView
//        Toast.makeText(this, txt.text.toString(), Toast.LENGTH_SHORT).show()
//        Log.d("txt", txt.text.toString())

        Fuel.post("http://10.0.2.2:3000/comments", listOf("comment[name]" to name.text.toString(), "comment[content]" to content.text.toString())).response { request, response, result ->
            println(request)
            println(response)
            println(result)
        }

//        Fuel.get("http://10.0.2.2:3000/comments").responseString { request, response, result ->
//            //do something with response
//            result.fold({ d ->
//                Log.d("result", d.toString())
//            }, { err ->
//                Log.d("err", err.toString())
//            })
//        }
    }
}
