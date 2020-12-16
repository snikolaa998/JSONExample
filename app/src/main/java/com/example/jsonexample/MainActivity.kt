package com.example.jsonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonexample.adapter.UserAdapter
import com.example.jsonexample.model.UserModel
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvUserList = findViewById<RecyclerView>(R.id.rvUserList)
        val userList: ArrayList<UserModel> = ArrayList()
        try {
            val obj = JSONObject(getJSONFromAssets()!!)
            val usersArray = obj.getJSONArray("users")

            for (i in 0 until usersArray.length()) {
                val user = usersArray.getJSONObject(i)
                val id = user.getInt("id")
                val name = user.getString("name")
                val email = user.getString("email")
                val gender = user.getString("gender")
                val weight = user.getDouble("weight")
                val height = user.getInt("height")

                val phone = user.getJSONObject("phone")
                val mobile = phone.getString("mobile")
                val office = phone.getString("office")

                val userDetails = UserModel(id, name, email, gender, weight, height, mobile, office)
                userList.add(userDetails)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        rvUserList.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(this, userList)
        rvUserList.adapter = adapter
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