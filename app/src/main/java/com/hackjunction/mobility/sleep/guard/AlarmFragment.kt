package com.hackjunction.mobility.sleep.guard

import android.animation.ValueAnimator
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hackjunction.mobility.R
import com.hackjunction.mobility.databinding.AlarmFragmentBinding
import kotlinx.android.synthetic.main.alarm_fragment.*
import okhttp3.*
import timber.log.Timber
import java.io.IOException


class AlarmFragment : Fragment() {
    private lateinit var binding: AlarmFragmentBinding
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var myMediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countDownTimer = object : CountDownTimer(10_000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                Timber.i("onTick")
            }

            override fun onFinish() {
                //TODO: PUT YOUR NUMBER
                sendSms("")
            }
        }
    }


    private fun sendSms(number: String) {
        val okHttpClient = OkHttpClient()

        val request = Request.Builder()
            .url("https://contafe.com/nic/junction2018.php?receiver=$number&msg=Driver with null ID is not responding to sleep tracker. You should contact to make sure he/she's fine. Location: -1, -1")
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Timber.e("Failure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                Timber.i("Fine")
            }

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.alarm_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myMediaPlayer = MediaPlayer.create(activity, R.raw.alarm)
        myMediaPlayer.start()
        countDownTimer.start()

        snoozeButton.setOnClickListener {
            this.findNavController().navigate(AlarmFragmentDirections.actionAlarmFragmentToTimerFragment(600))
        }

        val anim = ValueAnimator.ofFloat(0F, 1F)
        anim.duration = 2000

        val hsv = FloatArray(3) // Transition color
        hsv[1] = 1f
        hsv[2] = 1f
        anim.addUpdateListener { animation ->
            hsv[0] = 360 * animation.animatedFraction

            val runColor = Color.HSVToColor(hsv)
            binding.fragmentBackground.setBackgroundColor(runColor)
        }

        anim.repeatCount = Animation.INFINITE

        anim.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        myMediaPlayer.stop()
        countDownTimer.cancel()
        binding.unbind()
    }
}