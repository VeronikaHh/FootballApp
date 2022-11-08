package com.example.holovanova_football.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    private var _binding: VB? = null

    private val binding get() = _binding!!

    abstract fun inflateBinding(layoutInflater: LayoutInflater): VB

    companion object{
        private const val LIFECYCLE_TAG = "LifecycleEvent"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onCreateView")
        _binding = inflateBinding(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onDestroyView")
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        Log.d(LIFECYCLE_TAG,"${javaClass.simpleName} onDestroy")
        super.onDestroy()
    }
}