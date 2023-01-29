package com.fuzzyhouse.wonderwoollie

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fuzzyhouse.wonderwoollie.domain.ViMod
import com.fuzzyhouse.wonderwoollie.entity.Util.geoCo
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class ConccococFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_conccococ, container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContexthyhy = context
    }


    val sharePhhyyh: SharedPreferences by inject(named("SharedPreferences"))
    val viewMainModelhyhyhy by activityViewModel<ViMod>(named("MainModel"))

    lateinit var countryhyhy: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewMainModelhyhyhy.countryCode.observe(viewLifecycleOwner) {
            if (it!=null) {
                countryhyhy = it.couhy
                sharePhhyyh.edit().putString(geoCo, countryhyhy).apply()
                findNavController().navigate(R.id.action_conccococFragment_to_seeecMaaainFragment)
            }
        }
    }

    private lateinit var mContexthyhy: Context
}