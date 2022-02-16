package com.example.balltouchapp

import android.graphics.Color
import android.util.Log

class Util {

    fun getColor(): Int {

        val range = (0..255)
        val rr = range.random()
        val gg = range.random()
        val bb = range.random()

        val s = "#" + rr.toString(16) + gg.toString(16) + bb.toString(16)
        //#FF0033

        return Color.parseColor(s)
    }

    fun getFloat(): Float {
        val range = (20..100)
        return range.random().toFloat()
    }

    fun getAddColor(c1: Int, c2: Int): Int {
        val c1st = c1.toString(16)
        Log.d("TAG", "base1:$c1st")
        val c1rr = c1st.substring(1,3).toInt(16)
        val c1gg = c1st.substring(3,5).toInt(16)
        val c1bb = c1st.substring(5,7).toInt(16)

        val c2st = c2.toString(16)
        Log.d("TAG", "base2:$c2st")
        val c2rr = c2st.substring(1,3).toInt(16)
        val c2gg = c2st.substring(3,5).toInt(16)
        val c2bb = c2st.substring(5,7).toInt(16)

        val mixRR = (c1rr + c2rr) / 2
        val mixGG = (c1gg + c2gg) / 2
        val mixBB = (c1bb + c2bb) / 2

        val colorString = "#" + mixRR.toString(16) + mixGG.toString(16) + mixBB.toString(16)

        Log.d("TAG", "mixed:$colorString")
        return Color.parseColor(colorString)
    }

}