package com.ctyeung.androidchartex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ctyeung.androidchartex.databinding.ActivityPieChartBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.MPPointF

class PieChartActivity : AppCompatActivity(), OnChartValueSelectedListener {
    lateinit var binding:ActivityPieChartBinding
    lateinit var chart:PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pie_chart)
        binding.layout = this
        chart = binding.chart

        initChar()
        chart.invalidate()
    }

    fun initChar() {

        var values = ArrayList<PieEntry>()
        var count = 10
        var range = 100
        for (i in 0..count) {
            val v = (Math.random() * range)
            val entry = PieEntry(i.toFloat(), v.toFloat())
            values.add(entry)
        }

        var dataSet = PieDataSet(values, "test")

        dataSet.setDrawIcons(false)

        dataSet.setSliceSpace(3f)
        dataSet.setIconsOffset(MPPointF(0F, 40F))
        dataSet.setSelectionShift(5f)

        var data:PieData = PieData(dataSet)

        chart.animateY(1400, Easing.EaseInOutQuad)
        chart.data = data
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }
}