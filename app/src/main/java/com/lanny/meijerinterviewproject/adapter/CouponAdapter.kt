package com.lanny.meijerinterviewproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lanny.meijerinterviewproject.R
import com.lanny.meijerinterviewproject.model.ListOfCoupons
import kotlinx.android.synthetic.main.coupon_item.view.*
import org.w3c.dom.Text

class CouponAdapter(private var myList : List<ListOfCoupons>, private val context: Context): RecyclerView.Adapter<CouponAdapter.ViewHolder>(){

    private var recyclerView: RecyclerView? = null
    internal var onItemClick: ((ListOfCoupons) -> Unit)? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.coupon_item, p0, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList?.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.title.text = myList?.get(p1)?.title
        p0.description.text = myList?.get(p1)?.description
        p0.date.text = myList?.get(p1)?.date
        Glide.with(p0.itemView.context)
            .load(myList?.getOrNull(p1)?.imageUrl)
            .into(p0.img)
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_title)
        val description : TextView = itemView.findViewById(R.id.tv_desc)
        val clip : TextView = itemView.findViewById(R.id.tv_clip)
        val img : ImageView = itemView.findViewById(R.id.image_coupon)
        val date : TextView = itemView.findViewById(R.id.tv_date)

        init{
            clip.setOnClickListener{
                if(myList != null){
                    onItemClick?.invoke(myList!![adapterPosition])
                }
            }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }


}