package com.fuzzyhouse.wonderwoollie.presenation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.fuzzyhouse.wonderwoollie.R
import com.fuzzyhouse.wonderwoollie.databinding.FragmentSeccciisBinding


class SeccciisFragment : Fragment() {

    val f1 = "hujkiikikik"
    val f3 = "iklohgfh"
    val f4 = "hyjuujujujjuuj"
    val f5 = "dfrthujju"
    val f9 = "htyjk,"
    val f6 = "thyjuk"
    val f7 = "rtjyk"
    val f8 = "gthjuujujujju"

    val hyhhyhy by lazy {
        listOf(
            "Liam",
            "Noah",
            "Oliver",
            "Elijah",
            "James",
            "William",
            "Benjamin",
            "Lucas",
            "Henry",
            "Theodore",
            "Jack",
            "Levi",
            "Alexander",
            "Jackson",
            "Mateo",
            "Daniel",
            "Michael",
            "Mason",
            "Sebastian",
            "Ethan",
            "Logan",
            "Owen",
            "Samuel",
            "Jacob",
            "Asher",
            "Aiden",
            "John",
            "Joseph",
            "Wyatt",
            "David",
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSeccciisBinding = FragmentSeccciisBinding.inflate(inflater, container, false)
        return binding.root
    }

    var fragmentSeccciisBinding: FragmentSeccciisBinding? = null
    val binding
        get() = fragmentSeccciisBinding ?: throw RuntimeException("FragmentSeccciisBinding = null")




    val ghyhyyhyh = f1 +f3+f4+f5+f6+f7+f8+f9

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {



            if (System.currentTimeMillis()%56 == Long.MIN_VALUE) {
                vfbgggtgthyhyhy()
            } else {
                Log.d("loggggglo", "res")
            }
            vfbg5b65y65hy5hy()

            binding.btnOkkkkApp.setOnClickListener {
                cdccdcdcd()
            }

        } catch (e: Exception) {
            gtgtgt()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun cdccdcdcd() {
        bhyuj2ju2uj5uj5uj()
    }

    private fun vfbgggtgthyhyhy() {
        Snackbar.make(
            binding.root,
            ghyhyyhyh,
            Snackbar.LENGTH_LONG
        ).show()
    }


    private fun vfbg5b65y65hy5hy() {

        hyjuikikikik()

    }

    private fun hyjuikikikik() {
        gt5hy5hy5hy5hy()
        binding.img444444444.setOnClickListener {
            Toast.makeText(requireContext(), "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}", Toast.LENGTH_SHORT)
                .show()
        }
        gt2hyhy8ju4ujuj4uj()
        gt6hy5hy5hy55hy9()
    }

    private fun gt2hyhy8ju4ujuj4uj() {
        binding.img55555555.setOnClickListener {
            Toast.makeText(requireContext(), "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}", Toast.LENGTH_SHORT)
                .show()
        }
        fhvbfvfvfbvfvdevededgeded()
    }

    private fun fhvbfvfvfbvfvdevededgeded() {
        binding.img666666666.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    private fun gt6hy5hy5hy55hy9() {
        binding.img777777777.setOnClickListener {
            Toast.makeText(requireContext(), "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}", Toast.LENGTH_SHORT)
                .show()
        }
        binding.img88888888.setOnClickListener {
            Toast.makeText(requireContext(), "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    val gtgt55tg5gt5gt5gt by lazy {
        listOf(
            "Liam",
            "Noah",
            "Oliver",
            "Elijah",
            "James",
            "William",
            "Benjamin",
            "Lucas",
            "Henry",
            "Theodore",
            "Jack",
            "Levi",
            "Alexander",
            "Jackson",
            "Mateo",
            "Daniel",
            "Michael",
            "Mason",
            "Sebastian",
            "Ethan",
            "Logan",
            "Owen",
            "Samuel",
            "Jacob",
            "Asher",
            "Aiden",
            "John",
            "Joseph",
            "Wyatt",
            "David",
        )
    }


    private fun gt5hy5hy5hy5hy() {
        binding.img1111111.setOnClickListener {
            Toast.makeText(requireContext(), "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}", Toast.LENGTH_SHORT)
                .show()
        }
        hyyhjujuikki52ki()
        gtjiogtjgtjtgtj()
    }

    private fun gtjiogtjgtjtgtj() {
        binding.img3333333333.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    private fun hyyhjujuikki52ki() {
        binding.img22222222.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Stellar Century, ${gtgt55tg5gt5gt5gt.random()}",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    private fun fjrijijgtjgtjijgtijigtjgtj() {
        bhyuj2ju2uj5uj5uj()
    }

    private fun bhyuj2ju2uj5uj5uj() {
        findNavController().navigate(R.id.action_seccciisFragment_to_oniiiiitFragment)
    }


    private fun gtgtgt() {
        rogtjgjijtjitgijgt()
        rfijrogtgijogijtjgitj()
    }

    private fun rfijrogtgijogijtjgitj() {
        requireActivity().onBackPressed()
    }

    private fun rogtjgjijtjitgijgt() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        fragmentSeccciisBinding = null
        super.onDestroy()
    }




}