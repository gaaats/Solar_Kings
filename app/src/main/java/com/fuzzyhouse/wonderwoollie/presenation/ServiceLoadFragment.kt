package com.fuzzyhouse.wonderwoollie.presenation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.fuzzyhouse.wonderwoollie.R
import com.fuzzyhouse.wonderwoollie.databinding.FragmentServiceLaodBinding
import com.fuzzyhouse.wonderwoollie.domain.MainerVievModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped

@AndroidEntryPoint
@ActivityScoped
class ServiceLoadFragment : Fragment() {

    private val mainVeivModel by activityViewModels<MainerVievModel>()

    private var fragmentServiceLaodBinding: FragmentServiceLaodBinding? = null
    private val binding
        get() = fragmentServiceLaodBinding
            ?: throw RuntimeException("FragmentServiceLaodBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentServiceLaodBinding = FragmentServiceLaodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d("lolo", "created frag ServiceLoadFragment")

        mainVeivModel.loadDataFromApi()
        mainVeivModel.goFromFirstScreenToSecond.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(R.id.action_serviceLoadFragment_to_mainFilteringFragment)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }


}