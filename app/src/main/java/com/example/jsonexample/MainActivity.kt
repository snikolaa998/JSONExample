package com.example.jsonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonexample.adapter.UserAdapter
import com.example.jsonexample.model.User
import com.example.jsonexample.model.UserModel
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvUserList = findViewById<RecyclerView>(R.id.rvUserList)

        try {
            val jsonString = getJSONFromAssets()!!
            val users = Gson().fromJson(jsonString, User::class.java)

            rvUserList.layoutManager = LinearLayoutManager(this)
            val adapter = UserAdapter(this, users.users)
            rvUserList.adapter = adapter

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private fun getJSONFromAssets(): String? {
        var json: String? = null
        val charset: Charset = Charsets.UTF_8

        try {
            val `is` = assets.open("Users.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}