package com.chesire.malime.flow.series.list.manga

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.chesire.lifecyklelog.LogLifecykle
import com.chesire.malime.flow.series.list.SeriesListFragment

@LogLifecykle
class MangaFragment : SeriesListFragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.mangaSeries.observe(
            viewLifecycleOwner,
            Observer {
                newSeriesListProvided(it)
            }
        )
    }

    override fun toSearch() =
        findNavController().navigate(MangaFragmentDirections.toSearchFragment())
}
