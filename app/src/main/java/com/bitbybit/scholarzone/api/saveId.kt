package com.bitbybit.scholarzone.api

import android.content.Context
import android.content.SharedPreferences

fun saveId(context: Context, id: Int) {
    val sharedPref: SharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
    val sharedPrefEditor = sharedPref.edit()
    sharedPrefEditor.putInt("id", id)
    sharedPrefEditor.apply()
}