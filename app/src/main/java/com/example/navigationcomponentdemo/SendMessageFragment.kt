package com.example.navigationcomponentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigationcomponentdemo.databinding.FragmentSendMessageBinding
import androidx.fragment.app.setFragmentResultListener

class SendMessageFragment : Fragment() {
    private var _binding: FragmentSendMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding= FragmentSendMessageBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.sendButton.setOnClickListener{
            val message = binding.messageEdittext.text.toString()
            val action = SendMessageFragmentDirections.actionSendMessageFragmentToReplyFragment(message)
            rootView.findNavController().navigate(action)
        }
        setFragmentResultListener("REQUESTING_REPLY_KEY") {requestKey: String,bundle: Bundle->
            val replyText = bundle.getString("REPLY_KEY")
            binding.replyHeader.text = "Reply Received"
            binding.replyTextview.text=replyText
        }

        return rootView
    }
}