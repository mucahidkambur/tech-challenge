package com.mucahitkambur.kariyerchallenge.ui.main


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
import com.mucahitkambur.kariyerchallenge.util.commonTitle
import com.mucahitkambur.kariyerchallenge.util.showActionBar
import com.mucahitkambur.kariyerchallenge.util.statusBarColor
import com.mucahitkambur.kariyerchallenge.util.viewModelProvider
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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
    }

    private fun observeOrders() {
        viewModel.orderResult.observe(this, Observer {order ->
            order.data?.let {
                dataBinding.recycOrderds.adapter = OrderAdapter(it)
            }
        })
    }


    override fun onResume() {
        super.onResume()
        commonTitle(R.string.title_market)
        statusBarColor(R.color.red)
    }
}
