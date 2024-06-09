package com.moriss.portofolio
//<!--Fauzan Fadhil Moricio-->
//<!--10121077-->
//<!--IF2_PemAndro3-->
//<!--27 Mei 2024-->
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MusikFragment : Fragment() {

    private lateinit var adapter: MusikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var musikArrayList: ArrayList<Musik>

    private lateinit var imageId: Array<Int>
    private lateinit var judul: Array<String>
    private lateinit var artist: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_musik, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val verticalLayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycle_view_musik)
        recyclerView.layoutManager = verticalLayoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MusikAdapter(requireContext(), musikArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        musikArrayList = arrayListOf<Musik>()

        imageId = arrayOf(
            R.drawable.spotifylogo,
            R.drawable.spotifylogo,
            R.drawable.spotifylogo,
            R.drawable.spotifylogo,
            R.drawable.spotifylogo,
            R.drawable.spotifylogo,
            R.drawable.spotifylogo,
            R.drawable.spotifylogo,
        )

        judul = arrayOf(
            getString(R.string.musik1),
            getString(R.string.musik2),
            getString(R.string.musik3),
            getString(R.string.musik4),
            getString(R.string.musik5),
            getString(R.string.musik6),
            getString(R.string.musik7),
            getString(R.string.musik8),
        )

        artist = arrayOf(
            getString(R.string.link1),
            getString(R.string.link2),
            getString(R.string.link3),
            getString(R.string.link4),
            getString(R.string.link5),
            getString(R.string.link6),
            getString(R.string.link7),
            getString(R.string.link8),
        )

        val urls = arrayOf(
            "https://open.spotify.com/track/3FAclTFfvUuQYnEsptbK8w?si=d0145fb4a93f4da0",//link1
            "https://open.spotify.com/track/77KnJc8o5G1eKVwX5ywMeZ?si=334f5446f8f94876",//link2
            "https://open.spotify.com/track/5mbXd14GteojYPpciTLYDk?si=82448cd798f14f60",//link3
            "https://open.spotify.com/track/5eY7692tmgHB9dbmq6wa2M?si=5eeb1faf20f947e3",//link4
            "https://open.spotify.com/track/6xAIVrhyFQaHwPVWfUvWvE?si=e7e70c9cf9f144f4",//link5
            "https://open.spotify.com/track/14otco5CB29ffmhCEwjpHu?si=c7df1a39b2374d59",//link6
            "https://open.spotify.com/track/0Oqc0kKFsQ6MhFOLBNZIGX?si=eb9dc3117ac04f5a",//link7
            "https://open.spotify.com/track/5VOPZfKO6Q03IAiVckyAvU?si=47ab6a5d5d954dd4",//link8
        )

        for (i in imageId.indices) {
            val musikItem = Musik(imageId[i], judul[i], artist[i], urls[i])
            musikArrayList.add(musikItem)
        }
    }
}
