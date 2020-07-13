package com.ctyeung.androidchartex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ctyeung.androidchartex.databinding.ActivityRadarChartBinding
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class RadarChartActivity : AppCompatActivity(), OnChartValueSelectedListener {
    lateinit var binding:ActivityRadarChartBinding
    lateinit var chart:RadarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_radar_chart)
        binding.layout = this
        chart = binding.chart

        initChar()
        chart.invalidate()
    }

    fun initChar() {
        val factor = 80

        var entries1 = ArrayList<RadarEntry>()
        var entries2 = ArrayList<RadarEntry>()
        var count = 10
        for (i in 0..count) {
            val v1 = (Math.random() * factor)
            entries1.add(RadarEntry(v1.toFloat()))

            val v2 = (Math.random() * factor)
            entries2.add(RadarEntry(v2.toFloat()))
        }

        var radarDataSet1 = RadarDataSet(entries1, "test 1")
        var radarDataSet2 = RadarDataSet(entries2, "test 2")

        var sets = ArrayList<IRadarDataSet>()
        sets.add(radarDataSet1)
        sets.add(radarDataSet2)

        val data = RadarData(sets)
        chart.data = data
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }
}