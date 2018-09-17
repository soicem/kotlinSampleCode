package com.example.butterflyef.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main2.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter

var latitude : Double? = null
var longitude : Double? = null

class soicem:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        println(intent!!.getStringExtra("string"))
        latitude = intent.getDoubleExtra("Latitude", 0.0)
        longitude = intent.getDoubleExtra("Longitude", 0.0)
        //println(intent.getDoubleExtra("Latitude", 0.0))
        //println(intent.getDoubleExtra("Longitude", 0.0))
    }

}

class Main2Activity : AppCompatActivity() {
    var rec:BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

         rec = object:BroadcastReceiver() {
            override fun onReceive(context: Context, intent:Intent) {
                println(intent.extras)
                println(context)
            }
        }
        var filter = IntentFilter("android.intent.action.RUN")
        this.registerReceiver(rec, filter)
        fab.setOnClickListener(){
            println("I'm here " + longitude)
            println(latitude)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.unregisterReceiver(rec)
    }
}


