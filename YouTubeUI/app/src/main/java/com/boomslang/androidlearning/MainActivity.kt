package com.boomslang.androidlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambdaNInstance
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.boomslang.androidlearning.ui.theme.AndroidLearningTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidLearningTheme {
                Scaffold {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                            .verticalScroll(rememberScrollState())
                    ) {


                        Row(
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .fillMaxHeight()
                                    .background(Color.Red), contentAlignment = Alignment.Center
                            ) {
                                Text(text = "YouTube", fontWeight = FontWeight.Bold)
                            }
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .width(150.dp)
                                    .fillMaxHeight()
                            )
                            Icon(
                                Icons.Default.AccountBox, "", modifier = Modifier
                                    .size(40.dp)
                                    .padding(horizontal = 5.dp)
                            )
                            Icon(
                                Icons.Default.Notifications, "", modifier = Modifier
                                    .size(40.dp)
                                    .padding(horizontal = 5.dp)
                            )
                            Icon(
                                Icons.Default.Search, "", modifier = Modifier
                                    .size(40.dp)
                                    .padding(horizontal = 5.dp)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth()
                                .padding(10.dp)
                                .horizontalScroll(
                                    rememberScrollState()
                                )
                        ) {
                            for (i in 1..20) {
                                Box(modifier = Modifier.padding(horizontal = 2.dp)) {
                                    Text(
                                        "item $i",
                                        modifier = Modifier
                                            .background(Color.Gray)
                                            .padding(horizontal = 8.dp)
                                    )
                                }
                            }
                        }

                        for (i in 1..50) {
                            videoCard()
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun videoCard() {
    Column(modifier = Modifier.padding(bottom = 10.dp)) {
        Box(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .background(Color.Black)
        ) {
        }
        Row(
            modifier = Modifier
                .width(LocalConfiguration.current.screenWidthDp.dp)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
//            Box(
//                modifier = Modifier
//                    .height(50.dp)
//                    .width(50.dp)
//                    .background(Color.Gray, shape = CircleShape)
//            )
            Image(
                painter = rememberAsyncImagePainter("https://pixabay.com/get/g1a6fefe9485c6b760032f6911b638a3d98d161aa91855b252787edd2b614d8e14da9d0605e5434bb632d83fded0118ce_1280.jpg"),
                contentDescription = "",
                modifier = Modifier.size(50.dp).clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .width((LocalConfiguration.current.screenWidthDp - 100).dp)
                    .padding(horizontal = 5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Video Title herherbhebrh dbn and n agn f nra n gsn gsn sn  fn fgn sfn fdmb sdb dkjb sdkj bsdkjb dkjb dkjb sdjb skb skjdb ",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Channel Name · ${Random.nextInt(1000)}k Views · ${Random.nextInt(100)} days ago",
                    fontSize = 13.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "",
                modifier = Modifier.padding(vertical = 15.dp)
            )
        }
    }
}