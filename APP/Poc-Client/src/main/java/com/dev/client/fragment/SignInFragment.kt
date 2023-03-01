package com.dev.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import cloud.shoplive.sdk.ShopLiveUser
import com.dev.client.CampaignSettings
import com.dev.client.databinding.FragmentSigninBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSigninBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etId.setText("shoplive")
        binding.etPw.setText("shoplive")

        binding.btLogin.setOnClickListener {
            val id = binding.etId.text.toString()
            if (id.isNullOrEmpty()) {
                return@setOnClickListener
            }

            val shopliveUser = ShopLiveUser().apply {
                userId = id
            }
            CampaignSettings.authType(requireContext(), 0)
            CampaignSettings.user(requireContext(), shopliveUser)

            setFragmentResult("requestKey", bundleOf("userId" to id))
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}