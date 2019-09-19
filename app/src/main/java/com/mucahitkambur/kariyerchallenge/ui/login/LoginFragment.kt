package com.mucahitkambur.kariyerchallenge.ui.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mucahitkambur.kariyerchallenge.R
import com.mucahitkambur.kariyerchallenge.databinding.FragmentLoginBinding
import com.mucahitkambur.kariyerchallenge.di.Injectable
import com.mucahitkambur.kariyerchallenge.ui.MainViewModel
import com.mucahitkambur.kariyerchallenge.util.USER_NAME
import com.mucahitkambur.kariyerchallenge.util.USER_PASSWORD
import com.mucahitkambur.kariyerchallenge.util.viewModelProvider
import javax.inject.Inject

class LoginFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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
        }
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initListener()
    }

    private fun initListener() {

        // Giriş buton listener'ı
        dataBinding.buttonLogin.setOnClickListener {
            val username = dataBinding.textPerson.text.toString()
            val password = dataBinding.textPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(context, resources.getString(R.string.login_error), Toast.LENGTH_SHORT).show()
            }else if (username == USER_NAME && password == USER_PASSWORD){
                Toast.makeText(context, "Girdi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
