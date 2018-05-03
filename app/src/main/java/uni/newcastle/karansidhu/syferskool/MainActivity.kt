package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager



class MainActivity : AppCompatActivity() {

    lateinit var bnv: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewPager()
        setNavigationBar(findViewById(R.id.vpPager))
    }

    private fun setViewPager()
    {
        val screens = listOf(
                FragmentHome.newInstance(),
                FragmentTutorials.newInstance(),
                FragmentCustom.newInstance()
        )
        val viewPager = findViewById<ViewPager>(R.id.vpPager)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, screens)
        viewPager.currentItem = 0
        viewPager.addOnPageChangeListener(PageListener(findViewById(R.id.bottom_navigation)))
    }

    private fun setNavigationBar(viewPager: ViewPager)
    {
        val navigationMenu = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigationMenu.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_home -> viewPager.currentItem = 0
                R.id.action_tutorials -> viewPager.currentItem = 1
                R.id.action_custom -> viewPager.currentItem = 2
                else -> throw IllegalStateException("can't handle this fragment ID")
            }
            true
        }
    }
}
