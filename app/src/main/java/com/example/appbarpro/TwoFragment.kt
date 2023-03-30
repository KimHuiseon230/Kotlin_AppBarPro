package com.example.appbarpro

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appbarpro.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var binding: FragmentTwoBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity // 형변환
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return inflater.inflate(R.layout.fragment_two, container, false)
    }
}