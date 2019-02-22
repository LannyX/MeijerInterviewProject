package com.lanny.meijerinterviewproject.tabs

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.lanny.meijerinterviewproject.R
import com.lanny.meijerinterviewproject.adapter.CouponAdapter
import com.lanny.meijerinterviewproject.network.NetworkClientService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_available.*
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*


class AvailableFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_available, container, false)

        var recyclerView = view.findViewById(R.id.main_recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val retrofit : NetworkClientService.Creator = NetworkClientService
        val webAPI = retrofit.create()

        var response = webAPI.getCoupon("34lgBae%2FxIEnqksQpkn3w9F0JTKCafuiCr0ejLNLvBzlOlOZBa1CMA%3D%3D")
        response.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                Log.e("MainActivity", it.listOfCoupons[0].imageUrl)
                Log.e("MainActivity", it.couponCount)
                var myAdapter = CouponAdapter(it.listOfCoupons, context!!)
                recyclerView.adapter = myAdapter
                tv_total.text = it.couponCount + " TOTAL"

                myAdapter.onItemClick = {_ ->
                    Toast.makeText(activity, "Clicked", Toast.LENGTH_LONG).show()
                    activity?.view_pager?.setCurrentItem(2, true)
                    //view_pager.setCurrentItem(2, true)
                }
            }

        return view
    }

    companion object {
        val PAGE_NUM = "PAGE_NUM"
        fun newInstance(page: Int): AvailableFragment {
            val fragment = AvailableFragment()
            val args = Bundle()
            args.putInt(PAGE_NUM, page)
            fragment.setArguments(args)
            return fragment
        }
    }
}