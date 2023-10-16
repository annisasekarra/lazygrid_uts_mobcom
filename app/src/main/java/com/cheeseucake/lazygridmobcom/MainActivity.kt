package com.cheeseucake.lazygridmobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cheeseucake.lazygridmobcom.ui.theme.LazyGridMobcomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyGridMobcomTheme {
                // A surface container with a red background
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    val imageId = arrayOf(
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6,
                        R.drawable.p6,
                        R.drawable.p7,
                        R.drawable.p8,
                        R.drawable.p9,
                        R.drawable.p10
                    )
                    val names = arrayOf(
                        "Mobile Computing",
                        "Kewirausahaan",
                        "Data Mining",
                        "Pengantar Kecerdasan Buatan",
                        "Komputer dan Masyarakat",
                        "Animasi Komputer",
                        "STEM",
                        "Teori Bahasa dan Automata",
                        "Metode Penelitian",
                        "Etika Profesi"
                    )
                    val jumlahsks = arrayOf(
                        "3 sks",
                        "3 sks",
                        "3 sks",
                        "3 sks",
                        "2 sks",
                        "3 sks",
                        "3 sks",
                        "2 sks",
                        "2 sks",
                        "2 sks"

                    )
                    MyApp(imageId, names, jumlahsks)
                }
            }
        }
    }
}

@Composable
fun MyApp(
    imageId: Array<Int>,
    names: Array<String>,
    jumlahsks: Array<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = imageId.size
        items(itemCount) { item ->
            ColumnItem(
                itemIndex = item,
                painter = imageId,
                title = names,
                jumlahsks = jumlahsks,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    jumlahsks: Array<String>,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier = Modifier.size(100.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = title[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = jumlahsks[itemIndex],
                    fontSize = 18.sp
                )
            }
        }
    }
}
