package com.evreydima.quizbabe.quizReuslt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.evreydima.quizbabe.R
import com.evreydima.quizbabe.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class ResultFragment: Fragment(){

    @Inject
    lateinit var storage:DataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultTest = view.findViewById<TextView>(R.id.scoreTable)
        resultTest.text = getString(R.string.user_result, storage.test.score)
        val returnButton = view.findViewById<Button>(R.id.button)
        returnButton.setOnClickListener {
            storage.test.score = 0
            findNavController().popBackStack(R.id.loginFragment, false)
        }

    }
}