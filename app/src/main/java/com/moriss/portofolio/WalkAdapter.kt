package com.moriss.portofolio
//<!--Fauzan Fadhil Moricio-->
//<!--10121077-->
//<!--IF2_PemAndro3-->
//<!--27 Mei 2024-->
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class WalkAdapter(private val context: Context) : PagerAdapter() {

    private val images = arrayOf(
        R.drawable.profile_page,
        R.drawable.daily_page,
        R.drawable.gallery_page,
        R.drawable.musik_page
    )

    private val headings = arrayOf(
        R.string.heading_one,
        R.string.heading_two,
        R.string.heading_three,
        R.string.heading_fourth
    )

    private val descriptions = arrayOf(
        R.string.desc_one,
        R.string.desc_two,
        R.string.desc_three,
        R.string.desc_fourth
    )

    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slider_layout, container, false)

        val sliderTitleImage: ImageView = view.findViewById(R.id.titleImage)
        val sliderHeading: TextView = view.findViewById(R.id.texttitle)
        val sliderDescription: TextView = view.findViewById(R.id.textdescription)

        sliderTitleImage.setImageResource(images[position])
        sliderHeading.setText(headings[position])
        sliderDescription.setText(descriptions[position])

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}
