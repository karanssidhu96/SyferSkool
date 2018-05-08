package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

/**
 * Created by Karan Sidhu on 30/03/2018.
 */
class FragmentTutorials: Fragment() {

    val listMainText  = arrayListOf("Caesar", "ROT13", "Vigenère")
    val listSubText  = arrayListOf("Where it all began", "Caesar cipher advanced", "Multiple interwoven Caesar ciphers")
    lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance(): Fragment
        {
            var fb: FragmentTutorials = FragmentTutorials()
            return fb
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView : View = inflater!!.inflate(R.layout.fragment_tutorials, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerView)
        val adapter = RecyclerViewAdapter(activity, listMainText, listSubText)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        return rootView
    }
}
