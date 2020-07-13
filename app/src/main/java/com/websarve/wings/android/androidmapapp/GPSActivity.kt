package com.websarve.wings.android.androidmapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView

/**
 * GPSアクティビティ.
 */
class GPSActivity : AppCompatActivity() {
    /**
     * onCreate オーバーライド
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("GPSActivity AppCompatActivity", "start!!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_g_p_s)

        showPosition()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Log.i("GPSActivity AppCompatActivity", "end!!")
    }

    /**
     * showPosition 緯度経度の表示
     */
    private fun showPosition(){
        Log.i("GPSActivity showPosition", "start!!")
        val tvLatitude = findViewById<TextView>(R.id.tvLatitude)
        val tvLongitude = findViewById<TextView>(R.id.tvLongitude)

        // サンプル表示
        tvLatitude.text = "35.018060"
        tvLongitude.text = "138.933563"
        Log.i("GPSActivity showPosition", "end!!")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("GPSActivity onOptionsItemSelected", "start!!")
        if(item.itemId == android.R.id.home){
            Log.i("GPSActivity onOptionsItemSelected", "finish !!")
            finish()
        }
        Log.i("GPSActivity onOptionsItemSelected", "end!!")
        return super.onOptionsItemSelected(item)
    }
}