package com.bliss.hiltapp.databinding.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bliss.hiltapp.R
import com.bliss.hiltapp.databinding.ActivityPlainOldSolution2Binding
import com.bliss.hiltapp.databinding.data.Popularity
import com.bliss.hiltapp.databinding.data.SimpleViewModel

class PlainOldActivitySolution2 : AppCompatActivity() {
    lateinit var binding:ActivityPlainOldSolution2Binding

    private val viewModel by lazy {
        ViewModelProvider(this).get(SimpleViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plain_old_solution2)
//        DataBindingUtil.setContentView(this,R.layout.activity_plain_old_solution2)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_plain_old_solution2)
        binding.lifecycleOwner = this
        binding.name = "Ada"
        binding.lastName = "Lovelace"

        updateLikes()


    }

    private fun updateLikes() {
        binding.likes.text = viewModel.likes.toString()
        binding.progressBar.progress = (viewModel.likes * 100 / 5).coerceAtMost(100)
        val color = getAssociatedColor(viewModel.popularity, this)

        ImageViewCompat.setImageTintList(binding.imageView, ColorStateList.valueOf(color))//对图片着色

        binding.imageView.setImageDrawable(getDrawablePopularity(viewModel.popularity, this))
    }

    fun onLike(view: View) {
        viewModel.onLike()
        updateLikes()
    }

    private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
        return when (popularity) {
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            ).getColor(0, 0x000000)
            Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
            Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
        }
    }

    private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable? {
        return when (popularity) {
            Popularity.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            }
            Popularity.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
            Popularity.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
        }
    }
}