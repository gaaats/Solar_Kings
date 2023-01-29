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
import com.fuzzyhouse.wonderwoollie.entity.Util
import com.fuzzyhouse.wonderwoollie.entity.Util.codeCode
import com.fuzzyhouse.wonderwoollie.entity.Util.urlMain
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class SeeecMaaainFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewMainModelgt2t.mainId.observe(viewLifecycleOwner) {
            if (it != null) {
                val main = it.toString()
                sharePgttggt6.edit().putString("mainId", main).apply()
            }
        }

        viewMainModelgt2t.geo.observe(viewLifecycleOwner) {
            if (it != null) {

                countryDevgtgtgt = it.geohyju
                appsgt = it.appsCheckerhy
                wvgttg = it.viewhyhyujujuj

                sharePgttggt6.edit().putString(codeCode, countryDevgtgtgt).apply()
                sharePgttggt6.edit().putString(Util.apps, appsgt).apply()
                sharePgttggt6.edit().putString(urlMain, wvgttg).apply()

                findNavController().navigate(R.id.action_seeecMaaainFragment_to_beffforFiilFragment)
            }
        }
    }

    val viewMainModelgt2t by activityViewModel<ViMod>(named("MainModel"))
    lateinit var appsgt: String
    private lateinit var mContexthyhy: Context
    lateinit var countryDevgtgtgt: String
    lateinit var wvgttg: String


    val sharePgttggt6: SharedPreferences by inject(named("SharedPreferences"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_seeec_maaain, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContexthyhy = context
    }


}