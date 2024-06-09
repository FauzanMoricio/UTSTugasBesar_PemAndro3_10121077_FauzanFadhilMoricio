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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val galleryList = listOf(
            Gallery(R.drawable.x, getString(R.string.x1)),
            Gallery(R.drawable.q, getString(R.string.q1)),
            Gallery(R.drawable.p, getString(R.string.p1)),
            Gallery(R.drawable.s, getString(R.string.s1)),
            Gallery(R.drawable.l, getString(R.string.l1)),
            Gallery(R.drawable.k, getString(R.string.k1)),
            Gallery(R.drawable.m, getString(R.string.m1)),
            Gallery(R.drawable.v, getString(R.string.v1)),
            Gallery(R.drawable.y, getString(R.string.y1)),
            Gallery(R.drawable.t, getString(R.string.t1))
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = context?.let { GalleryAdapter(it, galleryList) }

        return view
    }
}



