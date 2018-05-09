package uni.newcastle.karansidhu.syferskool

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        titleTextView = findViewById(R.id.textView_tutorial_title)
        explanationTextView = findViewById(R.id.textView_tutorial_explanation)
        imageView = findViewById(R.id.imageView_tutorial)
        testTextView = findViewById(R.id.textView_tutorial_test_described)
        getIncomingIntent()
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
        }
    }

    private fun setTutorial(title : String, image : Int, explanation : String, test : String)
    {
        titleTextView.text = title
        imageView.setImageResource(image)
        explanationTextView.text = explanation
        testTextView.text = test
    }
}