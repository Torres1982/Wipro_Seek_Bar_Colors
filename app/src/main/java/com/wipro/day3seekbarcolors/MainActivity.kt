package com.wipro.day3seekbarcolors

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textViewColorPalette: TextView
    private lateinit var textViewRed: TextView
    private lateinit var textViewGreen: TextView
    private lateinit var textViewBlue: TextView
    private lateinit var seekBarRed: SeekBar
    private lateinit var seekBarGreen: SeekBar
    private lateinit var seekBarBlue: SeekBar
    private var red: Int = 0
    private var green: Int = 0
    private var blue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewColorPalette = findViewById(R.id.text_view_color_palette)
        textViewRed = findViewById(R.id.text_view_red)
        textViewGreen = findViewById(R.id.text_view_green)
        textViewBlue = findViewById(R.id.text_view_blue)
        seekBarRed = findViewById(R.id.seek_bar_red)
        seekBarGreen = findViewById(R.id.seek_bar_green)
        seekBarBlue = findViewById(R.id.seek_bar_blue)

        // Listen for changes when Seek Bar is being changed
        seekBarRed.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewRed.text = progress.toString()
                red = progress
                mixColors()
                //textViewColorPalette.setBackgroundColor(0xFF0000 + seekBarRed.progress * 0x10000)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarGreen.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewGreen.text = progress.toString()
                green = progress
                mixColors()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarBlue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewBlue.text = progress.toString()
                blue = progress
                mixColors()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun mixColors() {
        val mixedPalette: Int = Color.rgb(red, green, blue)
        setBackgroundColorOfMainTextView(mixedPalette)
    }

    private fun setBackgroundColorOfMainTextView(color: Int) {
        textViewColorPalette.setBackgroundColor(color)
    }
}

