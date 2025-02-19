package com.bitbybit.scholarzone.api

import android.content.Context
import android.content.SharedPreferences

fun getId(context: Context): Int {
    val sharedPref: SharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
    return sharedPref.getInt("id", -1)
}