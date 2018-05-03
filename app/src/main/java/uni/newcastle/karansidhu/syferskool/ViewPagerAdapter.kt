package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Karan Sidhu on 02/05/2018.
 */


class ViewPagerAdapter(fm: FragmentManager, private val fragments: List<Fragment>)
    : FragmentPagerAdapter(fm)
{
    override fun getItem(position: Int): Fragment = fragments[position]
    override fun getCount(): Int = fragments.size
}