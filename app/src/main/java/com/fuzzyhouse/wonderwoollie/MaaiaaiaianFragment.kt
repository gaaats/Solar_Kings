package com.fuzzyhouse.wonderwoollie

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fuzzyhouse.wonderwoollie.domain.ViMod
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class MaaiaaiaianFragment : Fragment() {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContextgtgt=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hkhyhyhyk.fbDeee(mContextgtgt)

        friofforjrfjrf()

    }

    private fun friofforjrfjrf() {
        findNavController().navigate(R.id.action_maaiaaiaianFragment_to_conccococFragment)
    }

    private lateinit var mContextgtgt: Context

    val hkhyhyhyk by activityViewModel<ViMod>(named("MainModel"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maaiaaiaian, container, false)
    }
}