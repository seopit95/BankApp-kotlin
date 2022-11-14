package com.example.chap11drawerlayout2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chap11drawerlayout2.databinding.DialogCustomBinding
import com.example.chap11drawerlayout2.databinding.FragmentThreeBinding
import com.example.chap11drawerlayout2.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {
    lateinit var binding: FragmentTwoBinding
    var dataList = mutableListOf<DataVO>()
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        for (i in 1..10) {
            if (i == 1) {
                dataList.add(
                    (DataVO(
                        "김동섭",
                        "인도네시아",
                        "UOB은행",
                        "11203456894",
                        "400,000",
                        R.drawable.uobbank
                    ))
                )
            } else if (i == 2) {
                dataList.add(
                    (DataVO(
                        "이기동",
                        "인도네시아",
                        "MANDIRI은행",
                        "03002312345244",
                        "520,000",
                        R.drawable.mandiribank
                    ))
                )
            } else if (i == 3) {
                dataList.add(
                    (DataVO(
                        "김강민",
                        "인도네시아",
                        "BTN은행",
                        "24213231112",
                        "800,000",
                        R.drawable.btnbank
                    ))
                )
            } else if (i == 4) {
                dataList.add(
                    (DataVO(
                        "박승훈",
                        "홍콩",
                        "HSBC은행",
                        "00477120023",
                        "950,000",
                        R.drawable.hsbcbank
                    ))
                )
            } else if (i == 5) {
                dataList.add(
                    (DataVO(
                        "최병서",
                        "싱가포르",
                        "UOB은행",
                        "68111354668",
                        "1,000,000",
                        R.drawable.uobbank
                    ))
                )
            } else if (i == 6) {
                dataList.add(
                    (DataVO(
                        "심지용",
                        "홍콩",
                        "HSBC은행",
                        "60022315568",
                        "800,000",
                        R.drawable.hsbcbank
                    ))
                )
            } else if (i == 7) {
                dataList.add(
                    (DataVO(
                        "이창현",
                        "인도네시아",
                        "MANDIRI은행",
                        "030099225311",
                        "1,300,000",
                        R.drawable.mandiribank
                    ))
                )
            }
        }
        //리사이클러뷰에 보일 레이아웃 설정
        val layoutManager = LinearLayoutManager(this.context)
        //리사이클러 뷰에 제공할 어댑터
        customAdapter = CustomAdapter(dataList)
        //리사이클러뷰에 연결
        binding.f2RecyclerView.layoutManager = layoutManager
        binding.f2RecyclerView.adapter = customAdapter
        binding.floatingActionButton.setOnClickListener {
            val dialog = CustomDialog(binding.root.context, binding)
            dialog.showDialog()
        }
        return binding.root
    }
    fun refreshRecyclerViewAdd(dataVO: DataVO) {
        Toast.makeText(binding.root.context, "정상적으로 이체되었습니다.", Toast.LENGTH_SHORT).show()
        dataList.add(dataVO)
    }

    fun refreshRecyclerViewDrop(dataVO: DataVO) {
        val bank = dataVO.bank
        val name = dataVO.name
        dataList.remove(dataVO)
        customAdapter.notifyDataSetChanged()
        Toast.makeText(
            binding.root.context,
            "${bank} - ${name}님께 이체한 내역이 삭제되었습니다.",
            Toast.LENGTH_SHORT
        ).show()
    }
}