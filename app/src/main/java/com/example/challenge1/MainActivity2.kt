package com.example.challenge1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.challenge1.data.Card
import com.example.challenge1.data.Finance
import com.example.challenge1.ui.theme.Challenge1Theme

class MainActivity2: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Challenge1Theme {

                HomeScreen()

            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun HomeScreen() {

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            WalletSection()
            CardsSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()

        }
    }
    @Composable
    fun WalletSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = "Wallet",
                    fontFamily = FontFamily(listOf(Font(R.font.inter_regular))),
                    fontSize = 17.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$ 44.475",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.inter_bold))),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color.LightGray)
                    .padding(6.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = Color.Black
                )
            }

        }
    }
    val cards = listOf(

        Card(
            cardType = "VISA",
            cardNumber = "3664 7865 3786 3976",
            cardName = "Business",
            balance = 46.467,
            cardBg = Color.Blue
        ),

        Card(
            cardType = "MASTER CARD",
            cardNumber = "234 7583 7899 2223",
            cardName = "Savings",
            balance = 6.467,
            cardBg =  Color(0xffCC009F)
        ),

        Card(
            cardType = "VISA",
            cardNumber = "0078 3467 3446 7899",
            cardName = "School",
            balance = 3.467,
            cardBg = Color.Blue
        ),

        Card(
            cardType = "MASTER CARD",
            cardNumber = "3567 7865 3786 3976",
            cardName = "Trips",
            balance = 26.47,
            cardBg =  Color(0xffCC009F)
        ),
    )



    @Composable
    fun CardsSection() {
        LazyRow {
            items(cards.size) { index ->
                CardItem(index)
            }
        }
    }

    @Composable
    fun CardItem(
        index: Int
    ) {
        val card = cards[index]

        val image = if (card.cardType == "MASTER CARD") {
            painterResource(id = R.drawable.ic_mastercard)
        } else{
            painterResource(id = R.drawable.ic_visa)
        }

        Box(
            Modifier.padding(9.dp)
        ){


            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .background(card.cardBg)
                    .width(250.dp)
                    .height(160.dp)
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
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
                    text = "$ ${card.balance}",
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

    @Composable
    fun FinanceSection() {


        val finances = mutableListOf(
            Finance(
                icon = Icons.Rounded.Star,
                name = "My\nBusiness",
                background = Color.Red
            ),

            Finance(
                icon = Icons.Rounded.Star,
                name = "My\nWallet",
                background = Color.Blue
            ),

            Finance(
                icon = Icons.Rounded.Star,
                name = "Finance\nAnalytics",
                background = Color.Green
            ),

            Finance(
                icon = Icons.Rounded.Star,
                name = "My\nTransactions",
                background = Color.Cyan
            ),
        )

        //Hint: add the new item to this list
        var FinanceList by remember {
            mutableStateOf(finances)
        }


        @Composable

        fun FinanceItem(
            index: Int,


            ) {
            val finance = FinanceList[index]
            Box(
                Modifier.padding(9.dp)
            ) {


                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(25.dp))
                        .background(Color(0xFF7A7A7A))
                        .width(120.dp)
                        .height(120.dp)
                        .padding(vertical = 12.dp, horizontal = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(finance.background, shape = CircleShape)
                            .padding(4.dp)
                    ) {
                        Icon(
                            imageVector = finance.icon,
                            contentDescription = ""
                        )
                    }

                    Text(
                        text = finance.name,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )


                }
            }
        }



        Column {
            Text(
                text = "Finance",
                fontSize = 24.sp,
                color = Color.Black,
                fontFamily = FontFamily(listOf(Font(R.font.inter_bold))),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

        }
        LazyRow {
            items(FinanceList.size) { index ->
                FinanceItem(index)
            }
        }
        Spacer(modifier = Modifier.height(34.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

            )
        {
            val buttonClickedState = remember {
                mutableStateOf(false)
            }

            Button(
                modifier = Modifier
                    .width(133.dp)
                    .height(40.dp),
                onClick = {


                    buttonClickedState.value = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF450065),
                    contentColor = Color(0xFF450065)
                ),
                shape = RoundedCornerShape(12.dp)
            )
            {
                Text(
                    text = "Add Finance",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
            if (buttonClickedState.value) {
                Box(contentAlignment = Alignment.TopCenter) {
                    Dialog(onDismissRequest = { buttonClickedState.value = false }) {
                        var FinanceName by remember { mutableStateOf("") }
                        Card(
                            shape = RectangleShape,
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier.size(317.dp, 209.dp),
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(top = 18.dp, start = 26.dp, end = 26.dp)
                            ) {
                                Text(
                                    text = "Add Finance",
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(20.dp))

                                TextField(
                                    value = FinanceName,
                                    onValueChange = { FinanceName = it },
                                    colors = TextFieldDefaults.colors(
                                        unfocusedContainerColor = Color.White,
                                        unfocusedTextColor = Color(0xFF8B8B8B),
                                        focusedTextColor = Color(0xFF250055),
                                        focusedContainerColor = Color.White,
                                        unfocusedIndicatorColor = Color(0xFF8B8B8B),
                                        focusedIndicatorColor = Color(0xFF250055),
                                    ),
                                    placeholder = {
                                        Text(
                                            text = "Name",
                                            fontSize = 16.sp,
                                            color = Color(0xFF8B8B8B),
                                            modifier = Modifier.padding(5.dp),
                                        )
                                    },
                                    modifier = Modifier.padding(bottom = 30.dp)
                                )
                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.align(Alignment.End)
                                ) {
                                    Text(
                                        text = "Add",
                                        color = Color(0xFF250055),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .clickable {
                                                val newList = FinanceList + Finance(
                                                    icon = Icons.Rounded.Star,
                                                    name = "New\n$FinanceName",
                                                    background = Color.Magenta
                                                )

                                                FinanceList = newList.toMutableList()

                                                buttonClickedState.value = false

                                            }
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                Box {}
            }


        }


    }}

