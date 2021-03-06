package com.hackjunction.mobility.sleep.guard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hackjunction.mobility.R
import com.hackjunction.mobility.databinding.TimerFragmentBinding
import net.crosp.libs.android.circletimeview.CircleTimeView


class TimerFragment : Fragment() {

    private lateinit var binding: TimerFragmentBinding
    private var isDestroyed = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.timer_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = TimerFragmentArgs.fromBundle(arguments)
        binding.circleTimerView.setCurrentTime(args.seconds.toLong())
        binding.circleTimerView.circleTimerListener = object : CircleTimeView.CircleTimerListener {
            override fun onTimerStop() {
                if (!isDestroyed)
                    view.findNavController().navigate(TimerFragmentDirections.actionTimerFragmentToQuestionFragment())
            }

            override fun onTimerStart(time: Long) {
            }

            override fun onTimerTimeValueChanged(time: Long) {
            }
        }

        binding.circleTimerView.startTimer()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        isDestroyed = true
        binding.circleTimerView.stopTimer()
        binding.unbind()
    }
}