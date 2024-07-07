package com.pushpo.medalcaseapp.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pushpo.medalcaseapp.View.Activity.MainActivity
import com.pushpo.medalcaseapp.View.Activity.MainActivity.Companion.setCurrentFragment
import com.pushpo.medalcaseapp.View.Fragment.FragmentAchievements
import com.pushpo.medalcaseapp.databinding.FragmentHomeBinding

/**
 * Home Fragment using to select panel to show forward.
 */
class FragmentHome : Fragment() {

    private var ACTIVITY: MainActivity? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAchievements.setOnClickListener {
            setCurrentFragment(FragmentAchievements(), ACTIVITY!!, true)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ACTIVITY = context as MainActivity
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}