package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.arch.lifecycle.ViewModel
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import org.koin.android.architecture.ext.viewModel

/**
 * Created by Karan Sidhu on 30/03/2018.
 */
class FragmentCustom: Fragment() {

    //val viewModel : CustomViewModel by viewModel()
    lateinit var cipherTypeSpinner : Spinner
    lateinit var result : TextView

    companion object {
        fun newInstance(): Fragment
        {
            var fb: FragmentCustom = FragmentCustom()
            return fb
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView : View = inflater!!.inflate(R.layout.fragment_custom, container, false)
        cipherTypeSpinner = rootView.findViewById(R.id.sp_cipher_type)
        result = rootView.findViewById(R.id.tv_spinner_test)

        val cipherTypes = arrayOf(getString(R.string.text_custom_cipher_type_shift), getString(R.string.text_custom_cipher_type_poly))
        cipherTypeSpinner.adapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, cipherTypes)

        cipherTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text = getString(R.string.text_custom_cipher_type_default)
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result.text = cipherTypes.get(p2)
            }
        }

        return rootView
    }

}
