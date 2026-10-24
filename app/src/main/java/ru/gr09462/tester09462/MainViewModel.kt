package ru.gr09462.tester09462

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

data class CardState(
    val card: CardData,
){
    val color: Color
        get() = card.isCorrect?.let {
            if(it)
                Color(0f, 1f, 0f, 0.15f)
            else
                Color(1f, 0f, 0f, 0.15f)
        } ?: Color.Transparent
    val isActive: Boolean
        get() = card.userAnswer == null
}

class MainViewModel : ViewModel() {
    val cards = mutableStateListOf<CardState>()

    var currentAnswer: String by mutableStateOf("")

    var currentCardNum: Int by mutableIntStateOf(0)

    init {
        initCards()
    }

    fun onUserInput(input: String){
        currentAnswer = input
    }
    fun onAnswer(){
        cards[currentCardNum].card.userAnswer = currentAnswer.toIntOrNull()
        currentCardNum++
        currentAnswer = ""
    }

    fun initCards(){
        cards.clear()
        currentCardNum = 0
        repeat(maxCardsCount){
            cards.add(CardState(CardData()))
        }
    }

    companion object {
        const val maxCardsCount = 5
    }
}