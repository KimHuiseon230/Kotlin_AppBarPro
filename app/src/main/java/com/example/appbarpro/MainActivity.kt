package com.example.appbarpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.appbarpro.databinding.ActivityMainBinding
import com.example.appbarpro.databinding.UsertabButtonBinding
import com.example.appbarpro.ui.CustomViewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var customViewpagerAdapter: CustomViewpagerAdapter
    lateinit var tabTitleList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //+++ RecyclerView (Adapter setting) Start
        customViewpagerAdapter = CustomViewpagerAdapter(this)
        customViewpagerAdapter.addListFragment(OneFragment())
        customViewpagerAdapter.addListFragment(TwoFragment())
        customViewpagerAdapter.addListFragment(ThreeFragment())
        tabTitleList = mutableListOf("car", "house", "air")
        binding.viewPager2.adapter = customViewpagerAdapter
        //+++ RecyclerView (Adapter setting) End

        //+++ tabLayout 와 viewPager2를 연결  : binding.tabLayout.addTab(tab1)
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tap, position ->
            // tab1.text ="FRAG1"
            tap.text = tabTitleList.get(position)
            tap.setCustomView(tabCustomView(position))
        }.attach()
        //+++ tabLayout 와 viewPager2 연결 End

        binding.eftb.setOnClickListener {
            Toast.makeText(applicationContext,"확장 탭이 클릭되었습니다.",Toast.LENGTH_SHORT).show()
        }
    }

    fun tabCustomView(position: Int): View {
        val binding = UsertabButtonBinding.inflate(layoutInflater) // 뷰 바인딩 진행 . 객체가 되었음.
        when (position) {
            0 -> binding.ivICon.setImageResource(R.drawable.car_24)
            1 -> binding.ivICon.setImageResource(R.drawable.house_24)
            2 -> binding.ivICon.setImageResource(R.drawable.black_24dp)
        }
        binding.tvTabName.text = tabTitleList.get(position)
        return binding.root
    }
}