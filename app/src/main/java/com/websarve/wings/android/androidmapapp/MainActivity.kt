package com.websarve.wings.android.androidmapapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast

/**
 * メインアクティビティ.
 */
class MainActivity : AppCompatActivity() {
    /**
     * onCreate オーバーライド
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MainActivity onCreate", "start!!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 履歴の表示
        showHistory()
        Log.i("MainActivity onCreate", "end!!")
    }

    /**
     * onCreateOptionsMenu オーバーライド
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Log.i("MainActivity onCreateOptionsMenu", "start!!")
        // メニューの表示
        menuInflater.inflate(R.menu.menu_option_menu_list, menu)

        Log.i("MainActivity onCreateOptionsMenu", "end!!")
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * onOptionsItemSelected オーバーライド
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("MainActivity onOptionsItemSelected", "start!!")
        when(item.itemId){
            R.id.menuListOptionLocation -> {
                Log.i("MainActivity onOptionsItemSelected", "selected menuListOptionLocation")
                val intent = Intent(applicationContext, GPSActivity::class.java)
                startActivity(intent)
            }
            R.id.menuListOptionExit -> {
                Log.i("MainActivity onOptionsItemSelected", "selected menuListOptionExit")
                finish()
            }
            R.id.menu_list_option_delete -> {
                Log.i("MainActivity onOptionsItemSelected", "selected menu_list_option_delete")

                // 履歴削除ダイアログを表示
                val deleteDialog = DeleteHistoryDialog()
                deleteDialog.show(supportFragmentManager, "DeleteHistoryDialog")
            }

        }
        Log.i("MainActivity onOptionsItemSelected", "end!!")
        return super.onOptionsItemSelected(item)
    }

    /**
     * showHistory 履歴リストの表示
     */
    private fun showHistory(){
        Log.i("MainActivity showHistory", "start!!")
        // サンプル
        val lvHistory = findViewById<ListView>(R.id.lvHistory)
        val menuList: MutableList<MutableMap<String,String>> = mutableListOf()
        var menu = mutableMapOf("position" to "サンプル現在地1", "day" to "2020/7/13 12:00")
        menuList.add(menu)
        menu = mutableMapOf("position" to "サンプル現在地2", "day" to "2020/7/14 12:00")
        menuList.add(menu)
        menu = mutableMapOf("position" to "サンプル現在地3", "day" to "2020/7/15 12:00")
        menuList.add(menu)

        val from = arrayOf("position","day")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(applicationContext, menuList, android.R.layout.simple_list_item_2, from, to)
        lvHistory.adapter = adapter
        Log.i("MainActivity showHistory", "end!!")
    }
}