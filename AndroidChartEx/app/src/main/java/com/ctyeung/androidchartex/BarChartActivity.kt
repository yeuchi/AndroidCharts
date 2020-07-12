package com.ctyeung.androidchartex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ctyeung.androidchartex.databinding.ActivityBarChartBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class BarChartActivity : AppCompatActivity(), OnChartValueSelectedListener {
    lateinit var binding:ActivityBarChartBinding
    lateinit var chart:BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bar_chart)
        binding.layout = this
        chart = binding.chart

        initBarChar()
        chart.invalidate()
    }

    fun initBarChar() {

        var values = ArrayList<BarEntry>()
        var count = 10
        var range = 100
        for (i in 0 .. count) {
            val v = (Math.random() * range)
            val entry = BarEntry(i.toFloat(), v.toFloat())
            values.add(entry)
        }

        var barDataSet:BarDataSet = BarDataSet(values, "some label")
        barDataSet.setDrawIcons(false)

        var dataSets = ArrayList<IBarDataSet>()
        dataSets.add(barDataSet)

        var data:BarData = BarData(dataSets)
        data.setValueTextSize(10f)
        data.barWidth = 0.9f
        chart.data = data
    }

    fun setStyles() {
        //        chart.setOnChartValueSelectedListener(this)
//        chart.setDrawBarShadow(false)
//        chart.setDrawValueAboveBar(true)
//        chart.description.setEnabled(false)
//        chart.setMaxVisibleValueCount(60)
//        chart.setPinchZoom(false)
//        chart.setDrawGridBackground(false)

        // chart.setDrawYLabels(false);
        //chart.marker = mv // Set the marker to the chart
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }
}