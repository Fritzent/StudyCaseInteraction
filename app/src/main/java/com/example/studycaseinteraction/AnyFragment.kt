package com.example.studycaseinteraction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_any.view.*

class AnyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_any, container, false)

        //here initialization any object that reference into MainActivity
        val mainActivity = activity as MainActivity

        //here the button click handle
        view.btn_use_activity_function.setOnClickListener {
            //here call a object that reference the MainActivity to get the Method from MainActivity
            mainActivity.summonFunctionMainActivity()
        }

        return view
    }

    fun fragmentFunction() {
        Toast.makeText(context,"This is the Function From Fragment", Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnyFragment().apply {
                arguments = Bundle().apply {
                    //here some code for the fragment can use in MainActivity
                }
            }
    }
}