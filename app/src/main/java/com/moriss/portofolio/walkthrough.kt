package com.moriss.portofolio
//<!--Fauzan Fadhil Moricio-->
//<!--10121077-->
//<!--IF2_PemAndro3-->
//<!--27 Mei 2024-->
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager

class Walkthrough : AppCompatActivity() {

    private lateinit var mSliderViewPager: ViewPager
    private lateinit var mDotLayout: LinearLayout
    private lateinit var backBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var skipBtn: Button
    private lateinit var dots: Array<TextView>
    private lateinit var walkAdapter: WalkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        backBtn = findViewById(R.id.backbtn)
        nextBtn = findViewById(R.id.nextbtn)
        skipBtn = findViewById(R.id.skipbtn)

        backBtn.setOnClickListener {
            val current = getItem(-1)
            if (current >= 0) {
                mSliderViewPager.currentItem = current
            }
        }

        nextBtn.setOnClickListener {
            val current = getItem(+1)
            if (current < dots.size) {
                mSliderViewPager.currentItem = current
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        skipBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        mSliderViewPager = findViewById(R.id.slideViewPager)
        mDotLayout = findViewById(R.id.indicator_layout)

        walkAdapter = WalkAdapter(this)
        mSliderViewPager.adapter = walkAdapter

        setUpIndicator(0)
        mSliderViewPager.addOnPageChangeListener(viewListener)
    }

    private fun setUpIndicator(position: Int) {
        dots = Array(4) { TextView(this) }
        mDotLayout.removeAllViews()

        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i].text = "●"
            dots[i].textSize = 15f
            dots[i].setTextColor(ContextCompat.getColor(this, R.color.inactive))
            mDotLayout.addView(dots[i])
        }

        if (dots.isNotEmpty()) {
            dots[position].setTextColor(ContextCompat.getColor(this, R.color.active))

        }
    }

    private val viewListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            setUpIndicator(position)
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun getItem(i: Int): Int {
        return mSliderViewPager.currentItem + i
    }
}
