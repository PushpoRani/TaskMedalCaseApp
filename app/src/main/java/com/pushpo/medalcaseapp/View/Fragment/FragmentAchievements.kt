package com.pushpo.medalcaseapp.View.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pushpo.medalcaseapp.Model.AchievementsItem
import com.pushpo.medalcaseapp.Model.Medal_Items
import com.pushpo.medalcaseapp.R
import com.pushpo.medalcaseapp.View.Adapter.AchievementListAdapter
import com.pushpo.medalcaseapp.databinding.FragmentAchievementsBinding


/**
 * FragmentView to show Achievements data
 */
class FragmentAchievements : Fragment(){

    private var arraylistAchievements = ArrayList<AchievementsItem>()
    private var _binding: FragmentAchievementsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAchievementsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backImg.setOnClickListener {

        }
        setAchievementItems()
    }

    /**
     * This function generates achievement list and set all the data using Recyclerview and Adapter
     */
    private fun setAchievementItems() {

        val listpersonalRecords = ArrayList<Medal_Items>()
        listpersonalRecords.add(Medal_Items(R.drawable.longest_run, "Longest Run", "00:00"))
        listpersonalRecords.add(Medal_Items(R.drawable.highest_elevation, "Highest Elevation", "2095 ft"))
        listpersonalRecords.add(Medal_Items(R.drawable.fastest_5k, "Fastest 5K", "00:00"))
        listpersonalRecords.add(Medal_Items(R.drawable.fastest_10k, "10K", "00:00:00"))
        listpersonalRecords.add(Medal_Items(R.drawable.fastest_half_marathon, "Half Marathon", "00:00"))
        listpersonalRecords.add(Medal_Items(R.drawable.fastest_marathon, "Marathon", "Not Yet"))

        arraylistAchievements.add(AchievementsItem(
            "Personal Records",
            "4 of 6", listpersonalRecords))

        val listVirtualRaces = ArrayList<Medal_Items>()
        listVirtualRaces.add(Medal_Items(R.drawable.virtual_half_marathon_race, "Virtual Half Marathon Race", "00:00"))
        listVirtualRaces.add(Medal_Items(R.drawable.tokyo_kakone_ekiden, "Tokyo-Hakone Ekiden 2020", "00:00:00"))
        listVirtualRaces.add(Medal_Items(R.drawable.virtual_10k_race, "Virtual 10K Race", "00:00:00"))
        listVirtualRaces.add(Medal_Items(R.drawable.hakone_ekiden, "Hakone Ekiden", "00:00:00"))
        listVirtualRaces.add(Medal_Items(R.drawable.mizuno_singapore_ekiden, "Mizuno Singapore Ekiden 2015", "00:00:00"))
        listVirtualRaces.add(Medal_Items(R.drawable.virtual_5k_race, "Virtual 5k Race", "23:07"))

        arraylistAchievements.add(AchievementsItem(
            "Virtual Races",
            "", listVirtualRaces))

        if (arraylistAchievements.size >0){
            binding.listAchievements.adapter = AchievementListAdapter(arraylistAchievements)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}