package com.mucahitkambur.kariyerchallenge.ui.login


import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mucahitkambur.kariyerchallenge.R
import com.mucahitkambur.kariyerchallenge.databinding.FragmentLoginBinding
import com.mucahitkambur.kariyerchallenge.di.Injectable
import com.mucahitkambur.kariyerchallenge.model.LoginState
import com.mucahitkambur.kariyerchallenge.ui.MainViewModel
import com.mucahitkambur.kariyerchallenge.util.*
import javax.inject.Inject

class LoginFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var preferences: SharedPreferences

    private lateinit var viewModel: MainViewModel

    private lateinit var dataBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = viewModelProvider(viewModelFactory)
        dataBinding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        ).apply {
            lifecycleOwner = this@LoginFragment
            viewModel = this@LoginFragment.viewModel
        }
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeLogin()

        // Beni Hatırla kontrolü
        if (checkRememberState())
            findNavController().navigate(R.id.action_fragment_login_to_main_fragment)
    }

    private fun checkRememberState(): Boolean{
        return preferences.getBoolean(PREF_REMEMBER, false)
    }

    // Login durumunu izleme ve cevaba göre işlem yapma
    private fun observeLogin(){
        viewModel.loginResult.observe(this, Observer {
            when (it){
                LoginState.SUCCESS -> {
                    findNavController().navigate(R.id.action_fragment_login_to_main_fragment)
                }
                LoginState.ERROR -> showError(resources.getString(R.string.login_msg_error))
                LoginState.EMPTY_NULL -> showError(resources.getString(R.string.login_msg_empty))
            }
        })
    }

    // Hata gösterme fonksiyonu
    private fun showError(error: String){
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        hideActionBar()
    }
}
