package ru.gr09462.tester09462

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.gr09462.tester09462.ui.TestCard
import ru.gr09462.tester09462.ui.theme.Tester09462Theme

class MainActivity : ComponentActivity() {

    private val vm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tester09462Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        if (vm.currentCardNum < MainViewModel.maxCardsCount) {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                items(vm.cards.slice(0..if (vm.currentCardNum < MainViewModel.maxCardsCount) vm.currentCardNum else -1)) { cardState ->
                                    TestCard(
                                        cardState.card,
                                        cardState.card.userAnswer?.toString() ?: vm.currentAnswer,
                                        isActive = cardState.isActive,
                                        cardColor = cardState.color,
                                        onUserInput = vm::onUserInput,
                                        onAnswer = vm::onAnswer,
                                    )
                                }
                            }
                        } else {
                            Text("Тест финишд")
                        }
                    }
                }
            }
        }
    }
}