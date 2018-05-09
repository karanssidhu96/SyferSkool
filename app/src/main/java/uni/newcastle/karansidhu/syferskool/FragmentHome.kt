package uni.newcastle.karansidhu.syferskool

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

/**
 * Created by Karan Sidhu on 30/03/2018.
 */
class FragmentHome: Fragment() {

    private lateinit var progressChart : PieChart
    private val totalTutorials : Float = 3f
    var tutorialsCompleted : Float = 0f

    companion object {
        fun newInstance(): Fragment
        {
            var fb: FragmentHome = FragmentHome()
            return fb
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.fragment_home, container, false)
        progressChart = rootView.findViewById(R.id.chart_progress)
        initalizeChart(progressChart)
        return rootView
    }

    private fun initalizeChart(chart : PieChart)
    {
        val enteries = mutableListOf(PieEntry(33.33f),
                PieEntry(100f - 33.33f))

        val pieDataSet = PieDataSet(enteries, "Tutorials Complete")
        val colors = mutableListOf(ContextCompat.getColor(activity, R.color.turquoise),
                ContextCompat.getColor(activity, R.color.colorPrimary))
        pieDataSet.colors = colors

        val pieData = PieData(pieDataSet)

        chart.holeRadius = 70f
        chart.centerText = "Tutorials Completed"
        chart.setCenterTextSize(40f)
        chart.setTouchEnabled(false)
        chart.description.isEnabled = false
        chart.legend.isEnabled = false
        chart.setHoleColor(Color.TRANSPARENT)
        chart.setCenterTextColor(ContextCompat.getColor(activity, R.color.white))

        chart.data = pieData
        chart.visibility = View.VISIBLE
        chart.invalidate()
    }

    private fun calculateCompletedPercentage() : Float
    {
        if (tutorialsCompleted == 0f)
        {
            return 0f
        }
        return totalTutorials.div(tutorialsCompleted) * 100f
    }
}