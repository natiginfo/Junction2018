package com.hackjunction.mobility.sleep.guard

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
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


class AlarmFragment : Fragment() {
    private lateinit var binding: AlarmFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.alarm_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        snoozeButton.setOnClickListener {
            this.findNavController().navigate(AlarmFragmentDirections.actionAlarmFragmentToTimerFragment())
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
}