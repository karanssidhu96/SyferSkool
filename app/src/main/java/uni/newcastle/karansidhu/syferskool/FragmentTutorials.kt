package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

/**
 * Created by Karan Sidhu on 30/03/2018.
 */
class FragmentTutorials: Fragment() {

    companion object {
        fun newInstance(): Fragment
        {
            var fb: FragmentTutorials = FragmentTutorials()
            return fb
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView : View = inflater!!.inflate(R.layout.fragment_tutorials, container, false)
        return rootView
    }
}
