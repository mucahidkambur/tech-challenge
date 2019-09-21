package com.mucahitkambur.kariyerchallenge.ui.main


import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mucahitkambur.kariyerchallenge.R
import com.mucahitkambur.kariyerchallenge.databinding.FragmentMainBinding
import com.mucahitkambur.kariyerchallenge.di.Injectable
import com.mucahitkambur.kariyerchallenge.ui.MainViewModel
import com.mucahitkambur.kariyerchallenge.util.*
import java.text.DateFormatSymbols
import java.time.Month
import java.time.format.TextStyle
import java.util.*
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var preferences: SharedPreferences

    private lateinit var viewModel: MainViewModel

    private lateinit var dataBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = viewModelProvider(viewModelFactory)
        dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeOrders()
        initListeners()
    }

    private fun initListeners() {
        //Çıkış butonu listener'ı
        dataBinding.buttonLogout.setOnClickListener {
            val builder = AlertDialog.Builder(context)
                builder.setMessage(R.string.dialog_msg)
                builder.setPositiveButton(R.string.dialog_btn_yes) { dialog, _ ->
                    preferences.edit().putBoolean(PREF_REMEMBER, false).apply()
                    dialog.dismiss()
                }
                builder.setNegativeButton(R.string.dialog_btn_no){ dialog, _ ->
                    dialog.dismiss()
                }
            builder.show()
        }
    }

    // Sunucudan gelen veriyi observe eden fonksiyon
    private fun observeOrders() {
        viewModel.orderResult.observe(this, Observer {order ->
            // Gelen verinin null kontrolü ve recyclerview için adapter oluşturulması
            order.data?.let {
                dataBinding.recyclerOrderds.adapter = OrderAdapter(it)
            }
        })
    }


    override fun onResume() {
        super.onResume()

        //Toolbar işlemleri
        showActionBar()
        commonTitle(R.string.title_market)
        statusBarColor(R.color.red)
    }
}
