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
import com.fuzzyhouse.wonderwoollie.entity.Util.apps
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class BeffforFiilFragment : Fragment() {



    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContexthyhy = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_befffor_fiil, container, false)
    }
    val viewMainModel226 by activityViewModel<ViMod>(named("MainModel"))
    val sharePhyhyhy: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var appCamphyhy: String
    private lateinit var mContexthyhy: Context


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkFlyhyhy26hy26 = sharePhyhyhy.getString(apps, null)
        val appsCamphyhyhy = sharePhyhyhy.getString("appCamp", null)

        if (checkFlyhyhy26hy26=="1" &&appsCamphyhyhy == null) {
            viewMainModel226.convers(mContexthyhy)
            viewMainModel226.appsData.observe(viewLifecycleOwner) {
                if (it != null) {
                    appCamphyhy = it.toString()
                    sharePhyhyhy.edit().putString("appCamp", appCamphyhy).apply()
                    findNavController().navigate(R.id.action_beffforFiilFragment_to_filllaFragment)
                }
            }
        } else {
            findNavController().navigate(R.id.action_beffforFiilFragment_to_filllaFragment)
        }
    }

}