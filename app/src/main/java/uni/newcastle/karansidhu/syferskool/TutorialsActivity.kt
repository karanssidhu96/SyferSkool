package uni.newcastle.karansidhu.syferskool

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*

/**
 * Created by Karan Sidhu on 08/05/2018.
 */

class TutorialsActivity : AppCompatActivity()
{
    lateinit var titleTextView : TextView
    lateinit var explanationTextView : TextView
    lateinit var imageView : ImageView
    lateinit var testTextView : TextView
    lateinit var inputEditText : EditText
    lateinit var testButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        titleTextView = findViewById(R.id.textView_tutorial_title)
        explanationTextView = findViewById(R.id.textView_tutorial_explanation)
        imageView = findViewById(R.id.imageView_tutorial)
        testTextView = findViewById(R.id.textView_tutorial_test_described)
        inputEditText = findViewById(R.id.editText_tutoiral)
        testButton = findViewById(R.id.button_tutorial)
        getIncomingIntent()
        test(testButton, titleTextView.text.toString())
    }

    private fun getIncomingIntent()
    {
        if (intent.hasExtra("title"))
        {
            val title = intent.getStringExtra("title")
            setTutorials(title)
        }
    }

    private fun setTutorials(title: String)
    {
        when (title)
        {
            "Caesar" -> setTutorial(title, R.drawable.caesar,
                    getString(R.string.text_caesar_explanation),
                    getString(R.string.text_caesar_test))
            "ROT13" -> setTutorial(title, R.drawable.rot13,
                    getString(R.string.text_ROT13_explanation),
                    getString(R.string.text_ROT13_test))
            "Vigenère" -> setTutorial(title, R.drawable.vigenere,
                    getString(R.string.text_vigenère_explanation),
                    getString(R.string.text_vigenère_test))
        }
    }

    private fun setTutorial(title : String, image : Int, explanation : String, test : String)
    {
        titleTextView.text = title
        imageView.setImageResource(image)
        explanationTextView.text = explanation
        testTextView.text = test
    }

    private fun test(btn : Button, title : String)
    {
        val polyCiphers = PolyCiphers()
        val shiftCiphers = ShiftCiphers()
        var correctAnswer = ""
        btn.setOnClickListener({
            when (title)
            {
                "Caesar" -> correctAnswer = shiftCiphers.shift("emperor", 3)
                "ROT13" -> correctAnswer = shiftCiphers.shift("thirteen", 13)
                "Vigenère" -> correctAnswer = polyCiphers.viegenere("blaise", "key",
                        true)
            }
            if (correctAnswer == inputEditText.text.toString())
            {
                Toast.makeText(applicationContext, "It works!", Toast.LENGTH_LONG).show()
            }
        })
    }
}