package com.timertiti.titi.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.timertiti.titi.R
import com.timertiti.titi.databinding.FragmentTimerBinding
import java.util.*
import kotlin.concurrent.timer

class TimerFragment : Fragment() {
    private var _binding: FragmentTimerBinding? = null
    private val binding get() = _binding!!
    private var timer: Timer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timer, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startButton.setOnClickListener {
            startTimer()
        }
        binding.stopButton.setOnClickListener {
            stopTimer()
        }
    }

    private fun stopTimer() {
        //TODO DB에 넣어놓은 시간대를 저장
        timer?.cancel()
        timer = null
    }

    private fun startTimer() {
        //TODO DB에서 시간을 꺼내와서 타이머 시작
        var time = 0
        if(timer == null) {
            timer = timer(initialDelay = 0, period = 1000) {
                val second = (time / 1000) % 60
                val minute = ((time / 1000) / 60) % 60
                val hour = (time / 1000) / 3600
                time += 1000
                requireActivity().runOnUiThread {
                    binding.timerTextView.text =
                        String.format("%02d:%02d:%02d", hour, minute, second)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        timer?.cancel()
        timer = null
    }

}