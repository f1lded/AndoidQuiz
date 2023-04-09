package com.evreydima.quizbabe.loginFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.evreydima.quizbabe.R
import com.evreydima.quizbabe.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment: Fragment() {
    @Inject
    lateinit var womanger:DataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button=view.findViewById<Button>(R.id.EnterButton)
        button.isEnabled = womanger.userName.isNotEmpty()
        button.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_quizFragment)
            }
        val userTextField = view.findViewById<EditText>(R.id.UserName)
        userTextField.doOnTextChanged{text, start, before, count ->
            womanger.userName = text.toString()
            button.isEnabled = womanger.userName.isNotEmpty()}
    }
}