package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.screens.PreviewItem
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Employee Data",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(8.dp))
                PreviewItem()
            }
        }
    }


    @Composable
    private fun PreviewMain() {
        LoadEmployeeData()

    }

    @Composable
    private fun LoadEmployeeData() {

        LazyColumn(content = {

            items(getEmployeeList()) {
                CardItem(employee = it)
            }
        })

    }

    @Preview
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun EditTextFun() {
        val state = remember { mutableStateOf("") }
        val counterOfET = remember {
            mutableStateOf(0)
        }

        Column {
            Text(text = "Character without space are -> ${counterOfET.value}",
                color = Color.Green,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = state.value,
                onValueChange = {
                    state.value = it
                    counterOfET.value = it.trim().length
                },
                label = {
                    Text(text = "Enter your name")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            CharWithSpaceCounter(counterOfET.value)
        }


    }


    @Composable
    private fun CharWithSpaceCounter(totalChar : Int = 0){
        Text(text = "Character with space are -> $totalChar",
            color = Color.Blue,
            fontSize = 18.sp
        )
    }

    @Composable
    private fun CardItem(employee: EmployeeData) {
        val rainbowColorsBrush = remember {
            Brush.sweepGradient(
                listOf(
                    Color(0xFF9575CD),
                    Color(0xFFBA68C8),
                    Color(0xFFE57373),
                    Color(0xFFFFB74D),
                    Color(0xFFFFF176),
                    Color(0xFFAED581),
                    Color(0xFF4DD0E1),
                    Color(0xFF9575CD)
                )
            )
        }
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(2.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {

            Row(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(2.dp, rainbowColorsBrush),
                            CircleShape
                        )
                        .weight(.2f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column(modifier = Modifier.weight(.6f)) {
                    Text(
                        text = employee.name,
                        color = Color.Green
                    )
                    Text(
                        text = employee.design,
                        color = Color.DarkGray
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(2.dp, rainbowColorsBrush),
                            CircleShape
                        )
                        .weight(.2f)
                )
            }
        }
    }

    data class EmployeeData(val name: String, val design: String)

    private fun getEmployeeList(): MutableList<EmployeeData> {
        val list = mutableListOf<EmployeeData>()

        list.add(EmployeeData("Seerat", "Android Developer"))
        list.add(EmployeeData("Sajjad bhai ", "Only bivi ke lye bacha paida krta he"))
        list.add(EmployeeData("Qaleem ", "Seerat se paise mangta he "))
        list.add(EmployeeData("Zulqarnen", "Seerat ke uthata he "))
        list.add(EmployeeData("NAveed", "Bahaane krta he"))
        list.add(EmployeeData("Azam Khan", "Fironiat phelata he"))
        list.add(EmployeeData("Amjad bhai", "Achha badna, golgapa khilata he"))
        list.add(EmployeeData("Seerat ka matrer", "Selfish"))
        list.add(EmployeeData("Rukhsana Baji waale", "Harami khandan"))
        list.add(EmployeeData("Baree Baaji ", "thugs of Pakistan"))
        list.add(EmployeeData("us se chhoti baaji", "achhee bandi"))
        list.add(EmployeeData("Bhabii", "total drama+film"))
        list.add(EmployeeData("oooja baji", "achee insaan"))
        list.add(EmployeeData("chhoti behn", "hawali+acheee"))
        list.add(EmployeeData("Hassan khan", "Darweshhh"))
        list.add(EmployeeData("Qambar khan", "Hoshyaar"))

        return list
    }

}