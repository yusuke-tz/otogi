package com.example.balltouchapp

import android.graphics.Color
import android.util.Log

class Util {
    var i:Int = 1

    fun getColor(): Int {

        val range = (0..255)
        val rr = range.random()
        val gg = range.random()
        val bb = range.random()

        return try {
            Color.rgb(rr, gg, bb)
        } catch (e: Exception) {
            getColor()
        }
    }

    fun getFloat(): Float {
        val range = (20..100)
        return range.random().toFloat()
    }

    fun getAddColor(c1: Int, c2: Int): Int {
        val mixRR = (Color.red(c1) + Color.red(c2)) / 2
        val mixGG = (Color.green(c1) + Color.green(c2)) / 2
        val mixBB = (Color.blue(c1) + Color.blue(c2)) / 2

        return Color.rgb(mixRR, mixGG, mixBB)
    }

}