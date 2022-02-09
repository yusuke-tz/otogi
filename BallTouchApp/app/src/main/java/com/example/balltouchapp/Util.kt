package com.example.balltouchapp

import android.graphics.Color
import android.util.Log

class Util {

    fun getColor(): Int {

        val range = (0..255)
        var rr = range.random()
        var gg = range.random()
        var bb = range.random()

        var s = "#" + rr.toString(16) + gg.toString(16) + bb.toString(16)
        //#FF0033

        return Color.parseColor(s)
    }

    fun getFloat(): Float {
        val range = (20..100)
        return range.random().toFloat()
    }

    fun getAddColor(c1: Int, c2: Int): Int {
        var c1st = c1.toString(16)
        Log.d("TAG", "base1:$c1st")
        var c1rr = c1st.substring(1,3).toInt(16)
        var c1gg = c1st.substring(3,5).toInt(16)
        var c1bb = c1st.substring(5,7).toInt(16)

        var c2st = c2.toString(16)
        Log.d("TAG", "base2:$c2st")
        var c2rr = c2st.substring(1,3).toInt(16)
        var c2gg = c2st.substring(3,5).toInt(16)
        var c2bb = c2st.substring(5,7).toInt(16)

        var mixrr = (c1rr + c2rr) / 2
        var mixgg = (c1gg + c2gg) / 2
        var mixbb = (c1bb + c2bb) / 2

        var colorString = "#" + mixrr.toString(16) + mixgg.toString(16) + mixbb.toString(16)

        Log.d("TAG", "mixed:$colorString")
        return Color.parseColor(colorString)
    }

}