package com.example.navigationcomponentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.navigationcomponentdemo.databinding.FragmentReplyBinding
import androidx.fragment.app.setFragmentResult

class ReplyFragment : Fragment() {
    private var _binding: FragmentReplyBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentReplyBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val args = ReplyFragmentArgs.fromBundle(requireArguments())
        binding.messageTextview.text = args.messageArg

        binding.sendReplyButton.setOnClickListener {
            val reply = binding.replyEdittext.text.toString()
            setFragmentResult("REQUESTING_REPLY_KEY", bundleOf("REPLY_KEY" to reply))
            rootView.findNavController().navigateUp()
        }

        return rootView
    }
}