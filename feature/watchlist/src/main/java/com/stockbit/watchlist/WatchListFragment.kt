package com.stockbit.watchlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.stockbit.common.base.BaseFragment
import com.stockbit.watchlist.databinding.FragmentWatchListBinding

class WatchListFragment : BaseFragment() {

    private lateinit var binding: FragmentWatchListBinding
    private lateinit var viewModel: WatchListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_watch_list, container, false)


        return binding.root
    }
}