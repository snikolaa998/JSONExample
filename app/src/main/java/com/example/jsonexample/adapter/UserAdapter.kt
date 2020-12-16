package com.example.jsonexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonexample.R
import com.example.jsonexample.model.UserModel

class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
    val userId: TextView = view.findViewById(R.id.tv_id)
    val userName: TextView = view.findViewById(R.id.tv_name)
    val userEmail: TextView = view.findViewById(R.id.tv_email)
    val userGender: TextView = view.findViewById(R.id.tv_gender)
    val userWeight: TextView = view.findViewById(R.id.tv_weight)
    val userHeight: TextView = view.findViewById(R.id.tv_height)
    val userMobileNumber: TextView = view.findViewById(R.id.tv_mobile)
    val userOfficeNumber: TextView = view.findViewById(R.id.tv_office_number)
}

class UserAdapter(private val context: Context, private val items: ArrayList<UserModel>) : RecyclerView.Adapter<UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_layout, parent, false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val item = items[position]
        with(holder) {
            userId.text = item.id.toString()
            userName.text = item.name
            userEmail.text = item.name
            userGender.text = item.gender
            userWeight.text = item.weight.toString()
            userHeight.text = item.height.toString()
            userMobileNumber.text = item.mobile
            userOfficeNumber.text = item.office
        }
    }
}