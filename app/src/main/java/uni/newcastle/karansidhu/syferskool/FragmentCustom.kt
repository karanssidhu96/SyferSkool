package uni.newcastle.karansidhu.syferskool

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Karan Sidhu on 30/03/2018.
 */
class FragmentCustom: Fragment() {

    companion object {
        fun newInstance(): Fragment
        {
            var fb: FragmentCustom = FragmentCustom()
            return fb
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_custom, container, false)
    }
}