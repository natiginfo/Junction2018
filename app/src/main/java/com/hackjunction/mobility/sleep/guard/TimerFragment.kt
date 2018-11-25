package com.hackjunction.mobility.sleep.guard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hackjunction.mobility.R
import com.hackjunction.mobility.databinding.TimerFragmentBinding

class TimerFragment : Fragment() {

    private lateinit var viewModel: TimerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: TimerFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.timer_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TimerViewModel::class.java)
        // TODO: Use the ViewModel
    }
}