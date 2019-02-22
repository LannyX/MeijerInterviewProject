package com.lanny.meijerinterviewproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Window
import com.lanny.meijerinterviewproject.adapter.CouponAdapter
import com.lanny.meijerinterviewproject.model.ListOfCoupons
import com.lanny.meijerinterviewproject.network.NetworkClientService
import com.lanny.meijerinterviewproject.tabs.AvailableFragment
import com.lanny.meijerinterviewproject.tabs.ClippedFragment
import com.lanny.meijerinterviewproject.tabs.PageAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_available.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window = this.getWindow()
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorBlue)

        val pageAdapter = PageAdapter(supportFragmentManager)

        pageAdapter.add(AvailableFragment.newInstance(0), "AVAILABLE")
        pageAdapter.add(ClippedFragment.newInstance(1), "CLIPPED")

        view_pager.adapter = pageAdapter
        tabs.setupWithViewPager(view_pager)



//        var myList = ArrayList<ListOfCoupons>()
//        myList.add(0, ListOfCoupons("Lord of the rings","good movie", null))
//        myList.add(0, ListOfCoupons("Titanic","romantic movie", null))
//        myList.add(0, ListOfCoupons("Inception","sci-fi movie", null))
//        main_recyclerView.adapter = CouponAdapter(myList, this)

//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl("https://meijerkraig.azurewebsites.net/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()

//        val webApi = retrofit.create(NetworkClientService::class.java)
//        var response = webApi.getCoupon("34lgBae%2FxIEnqksQpkn3w9F0JTKCafuiCr0ejLNLvBzlOlOZBa1CMA%3D%3D")
//        response.observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe{
//                Log.e("MainActivity", it.listOfCoupons[0].imageUrl)
//                Log.e("MainActivity", it.couponCount)
//                main_recyclerView.adapter = CouponAdapter(it.listOfCoupons, this)
//            }


    }
}
