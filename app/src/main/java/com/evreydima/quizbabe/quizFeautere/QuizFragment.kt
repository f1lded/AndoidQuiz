package com.evreydima.quizbabe.quizFeautere

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.evreydima.quizbabe.R
import com.evreydima.quizbabe.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragment: Fragment() {
    @Inject
    lateinit var manager: DataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeLabel = view.findViewById<TextView>(R.id.Text2)
        welcomeLabel.text = getString(R.string.welcome_user_text, manager.userName)
    }
}