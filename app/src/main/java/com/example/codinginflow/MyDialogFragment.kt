package com.example.codinginflow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.codinginflow.databinding.FragmentDialogBinding
import kotlinx.android.synthetic.main.fragment_dialog.*

class MyDialogFragment: DialogFragment() {

    private var _binding: FragmentDialogBinding? = null
    private val binding get() = _binding
    private var listener: OnButtonFragmentClicked? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDialogBinding.inflate(inflater ,container ,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_fragment.setOnClickListener {
            listener?.onClicked(edt_fragment.text.toString())
            dismiss()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnButtonFragmentClicked) listener = context

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnButtonFragmentClicked{
        fun onClicked(title: String)
    }

}