package com.example.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


@Preview(heightDp = 500)
@Composable
fun PreviewItem() {

    LazyColumn(content = {
        items(getCategoryList()) {
            ItemCategory(
                imgId = it.imgId,
                nameOfEmployee = it.nameOfEmployee,
                designationOfEmp = it.designationOfEmp
            )
        }
    })

    Column {
        getCategoryList().map {

        }
    }

}



@Composable
fun ItemCategory(
    imgId: Int,
    nameOfEmployee: String,
    designationOfEmp: String
) {

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
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(5.dp)
            .clickable {

            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp),
        ) {
            Image(
                painter = painterResource(id = imgId),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(4.dp, rainbowColorsBrush),
                        CircleShape
                    )

            )
            Spacer(modifier = Modifier.width(7.dp))
            ItemGeneric(
                nameOfEmployee, designationOfEmp,
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ItemGeneric(
    nameOfEmployee: String,
    designationOfEmp: String,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = nameOfEmployee, fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = designationOfEmp, fontSize = 12.sp)
    }
}

data class CategoryModel(
    val imgId: Int,
    val nameOfEmployee: String,
    val designationOfEmp: String
)

fun getCategoryList(): MutableList<CategoryModel> {
    val list = mutableListOf<CategoryModel>()
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Amjad",
            "Android Developer"
        )
    )
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Seerat",
            "Web Developer"
        )
    )
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Aslam ",
            "iOS developer"
        )
    )
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Virat",
            "Front-end"
        )
    )
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Anie",
            "Sales Manager"
        )
    )
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Salaar",
            "iOS Developer"
        )
    )
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Shafeeq",
            "Marketer"
        )
    )
    list.add(
        CategoryModel(
            R.drawable.emoji_icon,
            "Abdul Razzaq",
            "Flutter developer"
        )
    )


    return list
}