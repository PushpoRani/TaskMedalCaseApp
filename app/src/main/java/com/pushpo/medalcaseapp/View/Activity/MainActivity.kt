package com.pushpo.medalcaseapp.View.Activity

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.pushpo.medalcaseapp.Fragment.FragmentHome
import com.pushpo.medalcaseapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setCurrentFragment(FragmentHome(), this@MainActivity, false)
    }

    companion object {
        /**
         * This function works to change fragments within MainActivity
         * @param fragment
         * @param activity
         */
        fun setCurrentFragment(fragment: Fragment?, activity: Activity, isBackStacked: Boolean) {
            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentLayout, fragment!!)
            if (isBackStacked) fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            fragmentManager.executePendingTransactions()
        }
    }


}