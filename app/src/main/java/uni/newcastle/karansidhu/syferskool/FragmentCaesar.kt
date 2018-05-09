package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Karan Sidhu on 08/05/2018.
 */
class FragmentCaesar : Fragment()
{
    companion object {
        fun newInstance(): android.support.v4.app.Fragment
        {
            var fb: FragmentCaesar = FragmentCaesar()
            return fb
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.activity_tutorial, container, false)
    }
}