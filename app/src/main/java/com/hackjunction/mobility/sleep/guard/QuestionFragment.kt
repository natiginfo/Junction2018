package com.hackjunction.mobility.sleep.guard

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hackjunction.mobility.R
import com.hackjunction.mobility.databinding.QuestionFragmentBinding


class QuestionFragment : Fragment() {

    private lateinit var countDownTimer: CountDownTimer
    private lateinit var binding: QuestionFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countDownTimer = object : CountDownTimer(10_000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                updateTimeLeft(millisUntilFinished)
            }

            override fun onFinish() {
                startAlarm()
            }
        }
    }

    private fun updateTimeLeft(millisUntilFinished: Long) {
        binding.timeLeftText.text = "${millisUntilFinished / 1000}"
    }

    private fun startAlarm() {
        this.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToAlarmFragment())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.question_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countDownTimer.start()

        binding.notSleepyButton.setOnClickListener {
            this.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToTimerFragment())
        }
        binding.notSoSleepyButton.setOnClickListener {
            this.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToTimerFragment())
        }
        binding.kindOfSleepyButton.setOnClickListener {
            this.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToTimerFragment())
        }
        binding.sleepyButton.setOnClickListener {
            this.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToTimerFragment())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        countDownTimer.cancel()
        binding.unbind()
        super.onDestroyView()
    }

}
