package com.ctyeung.androidchartex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ctyeung.androidchartex.databinding.ActivityLineChartBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class LineChartActivity : AppCompatActivity(), OnChartValueSelectedListener {
    lateinit var binding:ActivityLineChartBinding
    lateinit var chart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_line_chart)
        binding.layout = this
        chart = binding.chart

        initLineChart()
    }
    /*
 * https://weeklycoding.com/mpandroidchart-documentation/getting-started/
 */
    fun initLineChart() {
        var entries = ArrayList<Entry>()

        for (i in 1..10) {
            entries.add(Entry(i.toFloat(), i.toFloat()))
        }

        var dataSet: LineDataSet = LineDataSet(entries, "Label")
        dataSet.setColor(Color.BLACK)
        dataSet.setValueTextColors(listOf(Color.BLACK, Color.BLUE))

        var lineData = LineData(dataSet)
        chart.data = lineData
        chart.invalidate()
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }

}