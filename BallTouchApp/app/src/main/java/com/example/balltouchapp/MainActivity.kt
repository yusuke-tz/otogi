package com.example.balltouchapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //２）新しいクラスを表示させる
        val ballView = BallView(this)
        setContentView(ballView)
    }

    class Ball(r:Float, x: Float, y: Float, color: Int) {
        var r: Float = r
        var x: Float = x
        var y: Float = y
        var color: Int = color
    }

    //１）Viewを継承したクラス
    class BallView(context: Context?) : View(context){
        private val util: Util = Util()
        private val backColor = Color.WHITE
        private var isBall1 = true
        private var contacting = false

        private var ball1 = Ball(util.getFloat(),1000F,1000F, backColor)
        private val ball2 = Ball(util.getFloat(),1000F,1000F, backColor)

        private var paint: Paint = Paint()

        //３）onDrawで描画の準備
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            canvas?.drawColor(backColor) //カンバス（拝啓）色

            //４）ペイントする色の指定と、丸い図形
            paint.color = ball1.color
            canvas?.drawCircle(ball1.x, ball1.y, ball1.r, paint)

            paint.color = ball2.color
            canvas?.drawCircle(ball2.x, ball2.y, ball2.r, paint)
        }

        //５）画面タッチ
        override fun onTouchEvent(event: MotionEvent?): Boolean {
            var ball: Ball
            try{
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        if(contacting) {
                            return true
                        }
                        if(isBall1) {
                            ball = ball1
                            isBall1 = false
                        } else {
                            ball = ball2
                            isBall1 = true
                        }
                        ball.x = event!!.x
                        ball.y = event.y
                        ball.r = util.getFloat()
                        ball.color = util.getColor()
                    }
                    MotionEvent.ACTION_MOVE -> {
                        if(contacting) {
                            return true
                        }
                        if(isBall1) {
                            ball = ball2
                        } else {
                            ball = ball1
                        }
                        ball.x = event!!.x
                        ball.y = event.y
                        if(isContact()){
                            ball1.x = (ball1.x + ball2.x) / 2
                            ball1.y = (ball1.y + ball2.y) / 2
                            ball1.r = (ball1.r + ball2.r)
                            ball1.color = util.getAddColor(ball1.color, ball2.color)

                            ball2.x = 10000F
                            ball2.y = 10000F
                            isBall1 = false
                            contacting = true
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        contacting = false
                    }
                    else -> {}
                }
                invalidate()
            } catch (e: Exception) {
                return false;
            } finally {
                //
            }
            //return super.onTouchEvent(event)
            return true
        }

        private fun isContact(): Boolean {
            val dx = ball1.x - ball2.x
            val dy = ball1.y - ball2.y
            val len = sqrt(dx*dx + dy*dy)
            return len < ball1.r + ball2.r
        }
    }

}


