package com.cryptochain.mota.db

expect class SPref

expect fun SPref.getInt(key: String): Int
expect fun SPref.setInt(key: String, value: Int)
expect fun SPref.getString(key: String): String
expect fun SPref.setString(key: String, value: String)
expect fun SPref.getBool(key: String): Boolean
expect fun SPref.setBool(key: String, value: Boolean)

class SharePreferences(private val context: SPref) {

    fun getInt(key: String): Int {
        return context.getInt(key)
    }

    fun putInt(key: String, value: Int) {
        context.setInt(key, value)
    }

    fun getString(key: String): String {
        return context.getString(key)
    }

    fun putString(key: String, value: String) {
        context.setString(key, value)
    }

    fun getBool(key: String): Boolean {
        return context.getBool(key)
    }

    fun putBool(key: String, value: Boolean) {
        context.setBool(key, value)
    }
}