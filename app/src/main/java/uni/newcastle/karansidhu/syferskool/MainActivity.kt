package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    lateinit var bnv: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv = findViewById<BottomNavigationView>(R.id.bottom_navigation) as BottomNavigationView
        bnv.setOnNavigationItemSelectedListener(object: BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var selectedFragment: Fragment? = null
                when(item.itemId)
                {
                    R.id.action_home ->
                            selectedFragment = FragmentHome.newInstance()

                    R.id.action_tutorials ->
                            selectedFragment = FragmentTutorials.newInstance()

                    R.id.action_custom ->
                            selectedFragment = FragmentCustom.newInstance()
                }
                var ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.frame_layout, selectedFragment)
                ft.commit()
                return true
            }
        })
        var ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_layout, FragmentHome.newInstance())
        ft.commit()
    }
}
