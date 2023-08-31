package com.companyname.apple_market

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.companyname.apple_market.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val item: Item? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.ITEM_OBJECT, Item::class.java)
        } else {
            intent.getParcelableExtra<Item>(Constants.ITEM_OBJECT)
        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("Owler", "itemPosition = $itemPosition")

        //받아온 이미지 넣기
        binding.detailIcon.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(
                resources,
                it.icon,
                null
            )
        })

        binding.name.text = item?.name
        binding.address.text = item?.address
        binding.detailproductName.text = item?.productName
        binding.detailproductExplanation.text = item?.productExplanation
        binding.detailprice.text = DecimalFormat("#,###").format(item?.price) + "원"

        binding.detailBackButton.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}