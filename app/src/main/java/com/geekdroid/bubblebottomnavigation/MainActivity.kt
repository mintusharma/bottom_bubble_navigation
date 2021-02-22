package com.geekdroid.bubblebottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.geekdroid.bottom_navigation.BubbleBottomNavigationLinearView
import com.geekdroid.bubblebottomnavigation.fragments.FavFragment
import com.geekdroid.bubblebottomnavigation.fragments.HomeFragment
import com.geekdroid.bubblebottomnavigation.fragments.NotificationFragment

class MainActivity : AppCompatActivity() {
    var selectedFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bubbleNavigation = findViewById<BubbleBottomNavigationLinearView>(R.id.bottom_navigation_view_linear)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            HomeFragment()
        ).commit()
        bubbleNavigation.setNavigationChangeListener { view, position ->
            when (position) {
                0 -> selectedFragment = HomeFragment()
                1 -> selectedFragment = FavFragment()
                2 -> selectedFragment = NotificationFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                selectedFragment!!).commit()
        }
    }
}