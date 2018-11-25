package com.hackjunction.mobility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hackjunction.mobility.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pairDeviceButton.setOnClickListener {
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToPairDeviceFragment())
        }

        binding.sleepGuardButton.setOnClickListener {
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToQuestionFragment())
        }
    }

    override fun onDestroyView() {
        binding.unbind()
        super.onDestroyView()
    }
}
