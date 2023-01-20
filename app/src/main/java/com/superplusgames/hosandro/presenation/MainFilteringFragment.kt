package com.superplusgames.hosandro.presenation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.superplusgames.hosandro.data.Constances
import com.superplusgames.hosandro.data.DataHolder
import com.superplusgames.hosandro.databinding.FragmentMainFilteringBinding
import com.superplusgames.hosandro.domain.MainerVievModel
import com.superplusgames.hosandro.gaameact.GaaammmyActivity2
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped

@AndroidEntryPoint
@ActivityScoped
class MainFilteringFragment : Fragment() {
    private val mainVeivModel by activityViewModels<MainerVievModel>()

    private var fragmentMainFilteringBinding: FragmentMainFilteringBinding? = null
    private val binding
        get() = fragmentMainFilteringBinding
            ?: throw RuntimeException("FragmentServiceLaodBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMainFilteringBinding = FragmentMainFilteringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        Log.d("lolo", "created frag MainFilteringFragment")

        val intentGame = Intent(activity, GaaammmyActivity2::class.java)
        val vebVeivIntent = Intent(activity, BrooooovvvssActivity::class.java)

        mainVeivModel.codeFromDevilHost.observe(viewLifecycleOwner){
            if (it == "1"){
                initAppsFlyerLibeer(requireActivity())
            }
        }

        mainVeivModel.makeCheckAllCheckers()
        mainVeivModel.goToGame.observe(viewLifecycleOwner){
            if (it) {
                startActivity(intentGame)
                requireActivity().finish()
            }
        }
        mainVeivModel.goFromToVebViev.observe(viewLifecycleOwner){
            if (it) {
                startActivity(vebVeivIntent)
                requireActivity().finish()
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            Log.d("lolo", "onConversionDataSuccess before loading")
            data?.get("campaign").toString().apply {
                DataHolder.naming = this
                DataHolder.tempNaminglLoad = this
                Log.d("lolo", "onConversionDataSuccess")
            }
        }

        override fun onConversionDataFail(p0: String?) {
            Log.d("lolo", "onConversionDataFail")
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
            Log.d("lolo", "onAppOpenAttribution")
        }

        override fun onAttributionFailure(p0: String?) {
            Log.d("lolo", "onAttributionFailure")
        }
    }

    private fun initAppsFlyerLibeer(context: Context) {
        AppsFlyerLib.getInstance()
            .init(Constances.APPS_KEY, conversionDataListener, context)
        Log.d("lolo", "initAppsFlyerLibeer")
        AppsFlyerLib.getInstance().start(context)
    }


}