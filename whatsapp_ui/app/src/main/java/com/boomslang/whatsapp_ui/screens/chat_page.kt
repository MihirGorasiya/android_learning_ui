package com.boomslang.whatsapp_ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.boomslang.whatsapp_ui.R
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatPage(navController: NavController) {
    var chats: List<Map<String, Any>> = listOf(
        mapOf(
            "sender_id" to 0,
            "sender" to "Boomslang",
            "Profile_photo" to "url",
            "message" to "Hi, There",
            "time" to LocalDate.parse("2024-09-09"),
        ),
        mapOf(
            "sender_id" to 1,
            "sender" to "Mihir Gorasiya",
            "Profile_photo" to "url",
            "message" to "Hello, how are you?",
            "last_seen" to LocalDate.parse("2024-09-07"),
            "unread" to 1
        ),
        mapOf(
            "sender_id" to 0,
            "sender" to "Boomslang",
            "Profile_photo" to "url",
            "message" to "I am good. I am going to play 8 pool! wanna join?",
            "time" to LocalDate.parse("2024-09-09"),
        ),
        mapOf(
            "sender_id" to 1,
            "sender" to "Mihir Gorasiya",
            "Profile_photo" to "url",
            "message" to "I was there yesterday, but why not?",
            "last_seen" to LocalDate.parse("2024-09-07"),
            "unread" to 1
        ),
        mapOf(
            "sender_id" to 1,
            "sender" to "Mihir Gorasiya",
            "Profile_photo" to "url",
            "message" to "What Time?",
            "last_seen" to LocalDate.parse("2024-09-07"),
            "unread" to 1
        )
    )
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Chats") }) }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column {


                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.DarkGray),
                    verticalArrangement = Arrangement.Bottom,
                ) {


                    items(chats.size) { index ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            horizontalArrangement =
                            if (chats[index]["sender_id"] == 0)
                                Arrangement.Start
                            else
                                Arrangement.End,

                            ) {
                            if (chats[index]["sender_id"] == 0) {
                                Box(
                                    modifier = Modifier
                                        .clip(shape = CircleShape)
                                        .height(30.dp)
                                        .width(30.dp)
                                        .background(color = Color.Gray)
                                )
                                Box(modifier = Modifier.width(3.dp))
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth(0.75f)
                                        .clip(shape = RoundedCornerShape(10.dp))
                                        .background(color = Color.Black)
                                        .padding(5.dp)

                                ) {
                                    Text(text = "${chats[index]["sender"]}", fontSize = 13.sp)
                                    Text(text = "${chats[index]["message"]}")
                                    Text(text = "${chats[index][""]}")
                                }
                            } else {

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth(0.75f)
                                        .clip(shape = RoundedCornerShape(10.dp))
                                        .background(color = Color.Black)
                                        .padding(5.dp)
                                ) {
                                    Text(text = "${chats[index]["sender"]}", fontSize = 13.sp)
                                    Text(text = "${chats[index]["message"]}")
                                }
                                Box(modifier = Modifier.width(3.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(shape = CircleShape)
                                        .height(30.dp)
                                        .width(30.dp)
                                        .background(color = Color.Gray)
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .height(75.dp)
                        .padding(10.dp)
                ) {
                    Row(modifier = Modifier) {
                        val textState = remember { mutableStateOf(TextFieldValue()) }
                        TextField(

                            value = textState.value,
                            onValueChange = { textState.value = it },
                            placeholder = { Text(text = "Message") },
                            leadingIcon = { Icon(Icons.Default.Face, contentDescription = "") },
                            trailingIcon = {
                                Row(modifier = Modifier.padding(8.dp)) {
                                    Icon(
                                        painterResource(id = R.drawable.baseline_attach_file_24),
                                        contentDescription = ""
                                    )
                                    Box(modifier = Modifier.width(10.dp))
                                    Icon(
                                        painterResource(id = R.drawable.outline_camera_alt_24),
                                        contentDescription = ""
                                    )
                                    Box(modifier = Modifier.width(10.dp))
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            shape = RoundedCornerShape(100),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.DarkGray,
                                disabledTextColor = Color.DarkGray,
                                unfocusedContainerColor = Color.DarkGray,

                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                            )
                        )
                        Box(modifier = Modifier.width(10.dp))
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color.Green)
                                .wrapContentSize(align = Alignment.Center)
                        ) {
                            Icon(
                                painterResource(id = R.drawable.baseline_mic_24),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
    }

}