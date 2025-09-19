package com.example.composebankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebankapp.data.Card
import com.example.composebankapp.ui.theme.BlueEnd
import com.example.composebankapp.ui.theme.BlueStart
import com.example.composebankapp.ui.theme.GreenEnd
import com.example.composebankapp.ui.theme.GreenStart
import com.example.composebankapp.ui.theme.OrangeEnd
import com.example.composebankapp.ui.theme.OrangeStart
import com.example.composebankapp.ui.theme.PurpleEnd
import com.example.composebankapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "MIR",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER_CARD",
        cardNumber = "3664 7865 3786 3977",
        cardName = "Savings",
        balance = 6.456,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3978",
        cardName = "School",
        balance = 3.467,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MIR",
        cardNumber = "3664 7865 3786 3979",
        cardName = "Trips",
        balance = 26.47,
        color = getGradient(GreenStart,GreenEnd)
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Composable
fun CardSelection() {
    LazyRow {
        items(cards.size) {
            CardItem(it)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    val image = when(card.cardType) {
        "MIR" -> {
            painterResource(id = R.drawable.ic_mir)
        }
        "VISA" -> {
            painterResource(id = R.drawable.ic_visa)
        }
        else -> {
            painterResource(id = R.drawable.ic_mastercard)
        }
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable{}
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }


}