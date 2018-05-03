package uni.newcastle.karansidhu.syferskool

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.arch.lifecycle.ViewModel
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.v4.content.ContextCompat
import android.widget.*
import org.koin.android.architecture.ext.viewModel

/**
 * Created by Karan Sidhu on 30/03/2018.
 */
class FragmentCustom: Fragment() {

    //val viewModel : CustomViewModel by viewModel()
    lateinit var cipherTypeSpinner : Spinner
    lateinit var noPicker: NumberPicker
    lateinit var keyEditText : EditText

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
        noPicker = rootView.findViewById(R.id.pick_shift)
        keyEditText = rootView.findViewById(R.id.edit_text_key)

        cipherTypeSpinnerSetUp(cipherTypeSpinner, keyEditText)
        numberPickerSetUp(noPicker)

        return rootView
    }

    private fun cipherTypeSpinnerSetUp(spinner: Spinner, key: EditText)
    {
        val adapter : ArrayAdapter<String> = ArrayAdapter(activity, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.text_array_cipher_types))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                disableEnableKey(key, p0?.getItemAtPosition(p2).toString())
            }
        }
    }

    private fun numberPickerSetUp(noPicker : NumberPicker)
    {
        noPicker.maxValue = 25
        noPicker.minValue = 0
        noPicker.wrapSelectorWheel = false
    }

    private fun disableEnableKey(key : EditText, cipherType : String)
    {
        if (cipherType == "Polyalphabetical")
        {
            key.isEnabled = false
            key.background.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(activity, R.color.colorDisabledEdit), PorterDuff.Mode.SRC_ATOP)
        }
        else
        {
            key.isEnabled = true
            key.background.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(activity, R.color.turquoise), PorterDuff.Mode.SRC_ATOP)
        }
    }

}
