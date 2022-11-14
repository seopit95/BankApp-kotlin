package com.example.chap11drawerlayout2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View

import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import com.example.chap11drawerlayout2.databinding.ActivityMainBinding
import com.example.chap11drawerlayout2.databinding.UsertabButtonBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    //토글버튼 부여
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    lateinit var oneFragment: OneFragment
    lateinit var twoFragment: TwoFragment
    lateinit var threeFragment: ThreeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //액션바대신에 툴바로 대체!
        setSupportActionBar(binding.toolbar)
        //액션토글 버튼 적용
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.drawer_open, R.string.drawer_close)
        //업버튼활성화
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //토글 sync
        toggle.syncState()

        oneFragment = OneFragment()
        twoFragment = TwoFragment()
        threeFragment = ThreeFragment()

        //어댑터 생성
        val pageAdapter = PageAdapter(this)
        val titleList = mutableListOf<String>("홈","이체내역","미래Pay")

        pageAdapter.addFragment(oneFragment, titleList[0])
        pageAdapter.addFragment(twoFragment, titleList[1])
        pageAdapter.addFragment(threeFragment, titleList[2])

        //뷰페이지 업대터 연결(필수)
        binding.viewPager.adapter = pageAdapter

        //탭 레이아웃과 뷰페이저를 연동(필수)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.setCustomView(tabCreateView(titleList[position]))
        }.attach()

//        //확장된 플로팅 액션기능을 확장 및 축소를 진행하기
//        binding.efab.setOnClickListener {
//            when(binding.efab.isExtended){
//                true -> binding.efab.shrink()
//                false -> binding.efab.extend()
//            }
//            Toast.makeText(applicationContext, "확장 앱", Toast.LENGTH_SHORT).show()
//        }
        binding.navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.itemInfo ->{Toast.makeText(applicationContext,"'내 계좌 관리'(을)를 선택하셨습니다", Toast.LENGTH_SHORT).show()}
                R.id.itemloan ->Toast.makeText(applicationContext,"'대출상담'(을)를 선택하셨습니다", Toast.LENGTH_SHORT).show()
                R.id.itemManager ->{Toast.makeText(applicationContext,"'상품관리'(을)를 선택하셨습니다", Toast.LENGTH_SHORT).show()}
                R.id.itemBonus ->{Toast.makeText(applicationContext,"'혜택'(을)를 선택하셨습니다", Toast.LENGTH_SHORT).show()}
                R.id.itemCustom ->{
                    Toast.makeText(applicationContext,"'고객센터'(을)를 선택하셨습니다", Toast.LENGTH_SHORT).show()
                    var intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:1688-9999")
                    if(intent.resolveActivity(packageManager) != null){
                        startActivity(intent)
                    }
                }
            }
            true
        }

    }


    //탭이름에 아이콘 설정
    private fun tabCreateView(title: String): View {
        val usertabButtonBinding = UsertabButtonBinding.inflate(layoutInflater)
        usertabButtonBinding.tvTabName.text = title // <-- 아이콘에 이름 새김
        when(title){
            "홈" ->{usertabButtonBinding.ivTabIcon.setImageResource(R.drawable.ic_baseline_home_24)}
            "이체내역" ->{usertabButtonBinding.ivTabIcon.setImageResource(R.drawable.ic_baseline_newspaper_24)}
            "미래Pay" ->{usertabButtonBinding.ivTabIcon.setImageResource(R.drawable.ic_payment_24)}
        }
        return usertabButtonBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //이벤트가 토글버튼에서 발생하면
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        when(item.itemId){
            R.id.menu_news ->{Toast.makeText(applicationContext, "새소식", Toast.LENGTH_SHORT).show()}
            R.id.menu_useGuide ->{Toast.makeText(applicationContext, "이용안내", Toast.LENGTH_SHORT).show()}
            R.id.menu_bankGuide ->{Toast.makeText(applicationContext, "영업점 안내", Toast.LENGTH_SHORT).show()}
            R.id.menu_support ->{Toast.makeText(applicationContext, "고객지원", Toast.LENGTH_SHORT).show()}
            R.id.menu_protect ->{Toast.makeText(applicationContext, "금융소비자보호", Toast.LENGTH_SHORT).show()}
            R.id.menu_search ->{Toast.makeText(applicationContext, "검색", Toast.LENGTH_SHORT).show()}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        //서치 메뉴 가져와서 이벤트 코드
        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        //가져온 서치메뉴 검색기능 이벤트 코드
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            //텍스트 입력 이벤트코드
            override fun onQueryTextSubmit(searchText: String?): Boolean {
                Log.d("chap11drawerlayout2", "${searchText}")
                return true
            }
            //텍스트 작성 후에 검색을 할 때 이벤트 코드
            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(applicationContext, "검색어 입력 중..", Toast.LENGTH_SHORT).show()
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}