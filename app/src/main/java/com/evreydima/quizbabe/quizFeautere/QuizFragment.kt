package com.evreydima.quizbabe.quizFeautere

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.evreydima.quizbabe.R
import com.evreydima.quizbabe.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragment: Fragment() {
    @Inject
    lateinit var manager: DataManager
    var first: RadioButton? = null
    var second: RadioButton? = null
    var third: RadioButton? = null
    var questionText: TextView? = null
    var answerGroup: RadioGroup? = null
    var button: Button? = null
    var index: Int = 0

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

        first = view.findViewById(R.id.Anwser1)
        second = view.findViewById(R.id.Anwser2)
        third = view.findViewById(R.id.Answer3)
        questionText = view.findViewById(R.id.question)
        answerGroup = view.findViewById(R.id.Group)
        button = view.findViewById(R.id.AnwserButton)



        button?.isEnabled = false
        button?.setOnClickListener {
            val vopros = manager.test.questions[index]
            val correctIndex = vopros.anwsers.indexOfFirst {
                it.isCorrect == true
                }
            if ( correctIndex == 0) {
                if (first?.isChecked == true) {
                    manager.test.score += 4
                }
            }else if (correctIndex == 1){
                if (second?.isChecked == true) {
                    manager.test.score += 4
                }
            }else if (correctIndex ==2){
                    if (third?.isChecked == true) {
                        manager.test.score += 4
                    }
                }



            index +=1
            if (index<=2) {
                showQuestion()
            } else {
                findNavController().navigate(R.id.action_quizFragment_to_resultFragment)
            }
            answerGroup?.clearCheck() 
        }


        first?.setOnClickListener {
            button?.isEnabled = true
        }
        second?.setOnClickListener {
            button?.isEnabled = true
        }
        third?.setOnClickListener {
            button?.isEnabled = true
        }
        showQuestion()


    }
    private fun showQuestion(){
        val vopros =  manager.test.questions[index]
        questionText?.text = vopros.text
        first?.text = vopros.anwsers[0].text
        second?.text = vopros.anwsers[1].text
        third?.text = vopros.anwsers[2].text
    }

}