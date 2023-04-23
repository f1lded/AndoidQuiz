package com.evreydima.quizbabe.helpers

import com.evreydima.quizbabe.model.Anwser
import com.evreydima.quizbabe.model.Question
import com.evreydima.quizbabe.model.Test

var anwser1 = Anwser(
    isCorrect = false,
    text = "нет"
)

var anwser2 = Anwser(
    isCorrect = false,
    text = "впр"
)

var anwser3 = Anwser(
    isCorrect = false,
    text = "отпимус прайм"
)

var question1 = Question(
    text = "Кто",
    anwsers = listOf(anwser1,anwser2,anwser3)
)

var question2 = Question(
    text = "Ты",
    anwsers = listOf(
        Anwser(
            isCorrect = false,
            text = "зачем"
        ),
        Anwser(
            isCorrect = true,
            text = "путин"
        ),
        Anwser(
        isCorrect = false,
        text = "нос"
        )
    )
)
var questio3 = Question(
    text = "Вор",
    anwsers = listOf(
        Anwser(
            isCorrect = false,
            text = "Лошаддь"
        ),
        Anwser(
            isCorrect = true,
            text = "ворона"
        ),
        Anwser(
            isCorrect = false,
            text = "хот"
        )
    )
)
val textExample = Test(
    score = 0,
    questions = listOf(question1,question2, questio3)
)
