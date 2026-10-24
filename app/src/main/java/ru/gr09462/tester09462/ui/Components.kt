package ru.gr09462.tester09462.ui

import android.graphics.Outline
import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.BeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.gr09462.tester09462.CardData
import ru.gr09462.tester09462.R
import ru.gr09462.tester09462.ui.theme.Tester09462Theme

@Composable
fun TestCard(
    cardData: CardData,
    userInput: String,
    modifier: Modifier = Modifier,
    isActive: Boolean = true,
    cardColor: Color = Color.Transparent,
    onUserInput: (String)->Unit = {},
    onAnswer: () -> Unit = {},
){
    val question = "${cardData.arg1} " +
            "${cardData.operation.symb} " +
            if (cardData.arg2 < 0) "(" else "" +
            "${cardData.arg2}" +
            if (cardData.arg2 < 0) ") = " else " = "
    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor = cardColor,
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(
                    question,
                    modifier = Modifier.weight(3f),
                    fontSize = 38.sp,
                    textAlign = TextAlign.Center,
                )
                OutlinedTextField(
                    value = userInput,
                    onValueChange = onUserInput,
                    modifier = Modifier.weight(1f),
                    textStyle = TextStyle(fontSize = 30.sp, textAlign = TextAlign.Center),
                    enabled = isActive,
                )
            }
            IconButton(onClick = onAnswer, enabled = isActive){
                Icon(
                    painter = painterResource(R.drawable.baseline_add_task_32),
                    contentDescription = null
                )

            }
        }
    }
}

@Preview
@Composable
fun TestCardPreview(){
    val c = CardData()
    Tester09462Theme(darkTheme = true) {
        TestCard(c, "")
    }
}