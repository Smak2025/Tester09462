package ru.gr09462.tester09462

import androidx.compose.material.ripple.R
import ru.gr09462.tester09462.Operation
import kotlin.random.Random


class CardData {
    val arg1: Int
    val arg2: Int
    val operation: Operation
    private val result: Int
    var userAnswer: Int? = null
    val isCorrect: Boolean?
        get() = userAnswer?.let { result == it }
    init {
        operation = Operation.entries.random()
        when(operation){
            Operation.PLUS,
            Operation.MINUS->{
                arg1 = Random.nextInt(-50,51)
                arg2 = Random.nextInt(-50,51)
                result = if (operation == Operation.PLUS) arg1 + arg2 else arg1 - arg2
            }
            Operation.TIMES -> {
                arg1 = Random.nextInt(-10,10)
                arg2 = Random.nextInt(-10,10)
                result = arg1 * arg2
            }
            Operation.DIV -> {
                arg2 = Random.nextInt(1,11) * setOf(-1,1).random()
                result = Random.nextInt(1,11) * setOf(-1,1).random()
                arg1 = result * arg2
            }
        }
    }
}