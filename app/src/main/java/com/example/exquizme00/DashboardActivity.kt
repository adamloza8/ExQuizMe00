package com.example.exquizme00

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar
import kotlinx.android.synthetic.main.time_out_dialog.*

var countDownTimer: CountDownTimer? = null
var timerValue = 20
var progressBar: RoundedHorizontalProgressBar? = null


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)



        countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerValue -= 1
                progressBar!!.progress = timerValue
            }

            override fun onFinish() {
                val dialog = Dialog(this@DashboardActivity, R.style.Dialogue)
                dialog.window!!.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                dialog.setContentView(R.layout.time_out_dialog)
                dialog.btn_tryAgain.setOnClickListener {
                    val intent =  Intent(this@DashboardActivity, MainActivity::class.java)
                    startActivity(intent)
                }

                dialog.show()
            }
        }.start()
    }
}