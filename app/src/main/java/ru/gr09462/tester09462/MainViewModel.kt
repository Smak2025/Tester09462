package ru.gr09462.tester09462

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var currentAnswer: String by mutableStateOf("")

    var currentCard: CardData = CardData()

    var cardColor: Color by mutableStateOf(Color.Transparent)

    fun onUserInput(input: String){
        currentAnswer = input
    }
    fun onAnswer(){
        currentCard.userAnswer = currentAnswer.toIntOrNull()
        cardColor = currentCard.isCorrect?.let {
            if(it) Color.Green else Color.Red
        } ?: Color.Transparent

    }
}