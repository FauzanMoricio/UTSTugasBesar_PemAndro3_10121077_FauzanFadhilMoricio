package com.moriss.portofolio
//<!--Fauzan Fadhil Moricio-->
//<!--10121077-->
//<!--IF2_PemAndro3-->
//<!--27 Mei 2024-->
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DailyFragment : Fragment() {

    private lateinit var verticalAdapter: MyAdapter
    private lateinit var verticalRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    private lateinit var horizontalAdapter: HorizontalImageAdapter
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var galleryList: List<Gallery>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var isi: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        // vertical RecyclerView list
        val verticalLayoutManager = LinearLayoutManager(context)
        verticalRecyclerView = view.findViewById(R.id.recycle_view)
        verticalRecyclerView.layoutManager = verticalLayoutManager
        verticalRecyclerView.setHasFixedSize(true)
        verticalAdapter = MyAdapter(newsArrayList)
        verticalRecyclerView.adapter = verticalAdapter

        // horizontal RecyclerView
        val horizontalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView = view.findViewById(R.id.horizontal_recycler_view)
        horizontalRecyclerView.layoutManager = horizontalLayoutManager
        horizontalRecyclerView.setHasFixedSize(true)
        horizontalAdapter = HorizontalImageAdapter(requireContext(), galleryList)
        horizontalRecyclerView.adapter = horizontalAdapter
    }

    private fun dataInitialize() {
        newsArrayList = arrayListOf()
        galleryList = listOf(
            Gallery(R.drawable.adrian, getString(R.string.adrian)),
            Gallery(R.drawable.wildan, getString(R.string.wildan)),
            Gallery(R.drawable.nasza, getString(R.string.nasza)),
            Gallery(R.drawable.faliq, getString(R.string.faliq))
        )

        imageId = arrayOf(
            R.drawable.kamar,
            R.drawable.kuliah,
            R.drawable.game,
            R.drawable.nonton,
            R.drawable.tugas,
            R.drawable.olahraga,
            R.drawable.memasak,
            R.drawable.mencuci,
        )

        heading = arrayOf(
            getString(R.string.a),
            getString(R.string.b),
            getString(R.string.c),
            getString(R.string.d),
            getString(R.string.e),
            getString(R.string.f),
            getString(R.string.g),
            getString(R.string.h),
        )

        isi = arrayOf(
            getString(R.string.aa),
            getString(R.string.bb),
            getString(R.string.cc),
            getString(R.string.dd),
            getString(R.string.ee),
            getString(R.string.ff),
            getString(R.string.gg),
            getString(R.string.hh),
        )

        for (i in imageId.indices) {
            val newsItem = News(imageId[i], heading[i], isi[i])
            newsArrayList.add(newsItem)
        }
    }
}
