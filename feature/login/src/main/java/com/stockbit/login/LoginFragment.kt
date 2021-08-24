package com.stockbit.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.login.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel


    override fun getViewModel(): BaseViewModel{
     viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application).create(
         LoginViewModel::class.java)
        return viewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnLogin.setOnClickListener {
            if (isFieldNotEmpty()){
                findNavController().navigate(R.id.action_loginFragment_to_watchlistFragment)
            }
        }
        return binding.root
    }

    private fun isFieldNotEmpty(): Boolean{
        if (binding.edtUsername.text.isNullOrEmpty() || binding.edtPassword.text.isNullOrEmpty()){
            Toast.makeText(requireContext(), getString(R.string.alert_wrong_username_and_password), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}