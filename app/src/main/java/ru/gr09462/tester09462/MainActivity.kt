package ru.gr09462.tester09462

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
                        TestCard(
                            vm.currentCard,
                            vm.currentAnswer,
                            cardColor = vm.cardColor,
                            onUserInput = vm::onUserInput,
                            onAnswer = vm::onAnswer,
                        )
                    }
                }
            }
        }
    }
}