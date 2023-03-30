package com.example.earthquake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earthquake.fg.EarthquakeListFragment
import java.util.Calendar

private const val TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT"

class EarthquakeMainActivity : AppCompatActivity() {

    private var earthquakeListFragment: EarthquakeListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_earthquake_main)

        val fragmentManager = supportFragmentManager
        if (savedInstanceState == null) {
            val transaction = fragmentManager.beginTransaction()
            earthquakeListFragment = EarthquakeListFragment()
            transaction.add(R.id.main_activity_frame, earthquakeListFragment!!, TAG_LIST_FRAGMENT)
            transaction.commitNow()
        } else {
            earthquakeListFragment =
                fragmentManager.findFragmentByTag(TAG_LIST_FRAGMENT) as EarthquakeListFragment
        }

        val now = Calendar.getInstance().time
        val dummyQuakes: List<Earthquake> = listOf(
            Earthquake("0", now, "San Jose", null, 7.3, null),
            Earthquake("1", now, "LA", null, 6.5, null)
        )
        earthquakeListFragment!!.setEarthquakes(dummyQuakes)
    }


}