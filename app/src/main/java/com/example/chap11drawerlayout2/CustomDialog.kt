package com.example.chap11drawerlayout2

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.icu.text.DecimalFormat
import android.os.Build
import android.text.Editable
import android.text.Selection
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.widget.doOnTextChanged
import com.example.chap11drawerlayout2.databinding.DialogCustomBinding
import com.example.chap11drawerlayout2.databinding.FragmentTwoBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class CustomDialog(val context: Context, val fragmentTwoBinding: FragmentTwoBinding) {
    val dialog = Dialog(context)

    fun showDialog(){
        val binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnBank.setOnClickListener {
            val items = arrayOf<String>("UOB은행", "HSBC은행", "BCA은행", "BNI은행", "MANDIRI은행", "BTN은행")
            val eventHandler = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, p1: Int) {
                    if (p1 == DialogInterface.BUTTON_POSITIVE) {
                    }
                }
            }
            val userDialog = AlertDialog.Builder(context)
            userDialog.setTitle("은행선택")
            userDialog.setIcon(android.R.drawable.ic_dialog_alert)
            userDialog.setSingleChoiceItems(items, 0, object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, index: Int) {
                    Toast.makeText(context, "${items[index]}을 선택하였습니다.", Toast.LENGTH_SHORT).show()
                    binding.tvBank.text = items[index]
                }
            })
            userDialog.setPositiveButton("확인", eventHandler)
            userDialog.setCancelable(false)
            userDialog.show().setCanceledOnTouchOutside(true)
        }

        binding.btnCancel.setOnClickListener{
            dialog.dismiss()
        }

        binding.btnOK.setOnClickListener{
            val bank = binding.tvBank.text.toString()
            val nation = binding.edtNation.text.toString()
            val account = binding.edtAccount.text.toString()
            val name = binding.edtName.text.toString()
            val money = binding.edtMoney.text.toString()
            lateinit var dataVO: DataVO
            if(bank.equals("UOB은행")){
                dataVO = DataVO(name, nation, bank, account, money, R.drawable.uobbank)
            }else if(bank.equals("HSBC은행")){
                dataVO = DataVO(name, nation, bank, account, money, R.drawable.hsbcbank)
            }else if(bank.equals("BCA은행")){
                dataVO = DataVO(name, nation, bank, account, money, R.drawable.bcabank)
            }else if(bank.equals("BTN은행")){
                dataVO = DataVO(name, nation, bank, account, money, R.drawable.btnbank)
            }else if(bank.equals("MANDIRI은행")){
                dataVO = DataVO(name, nation, bank, account, money, R.drawable.mandiribank)
            }else if(bank.isEmpty()){
                Toast.makeText(context, "은행을 선택해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            (context as MainActivity).twoFragment.refreshRecyclerViewAdd(dataVO)
            dialog.dismiss()


        }
    }



}