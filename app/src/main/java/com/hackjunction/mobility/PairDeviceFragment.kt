package com.hackjunction.mobility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.hackjunction.mobility.databinding.PairDeviceFragmentBinding


class PairDeviceFragment : Fragment() {


    private lateinit var viewModel: PairDeviceViewModel
    private lateinit var binding: PairDeviceFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.pair_device_fragment, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pairDeviceButton.setOnClickListener {
            this.findNavController().navigate(PairDeviceFragmentDirections.actionPairDeviceFragmentToQuestionFragment())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PairDeviceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
