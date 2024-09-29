package com.boomslang.whatsapp_ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.boomslang.whatsapp_ui.R
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(navController: NavController) {
    var users: List<Map<String, Any>> = listOf(
        mapOf(
            "user_name" to "Boomslang",
            "Profile_photo" to "url",
            "message" to "Hi, There",
            "last_seen" to LocalDate.parse("2024-09-09"),
            "unread" to 0
        ),
        mapOf(
            "user_name" to "Mihir Gorasiya",
            "Profile_photo" to "url",
            "message" to "Ohh, I was there yesterday",
            "last_seen" to LocalDate.parse("2024-09-07"),
            "unread" to 1
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "WhatsApp") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_camera_alt_24),
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_more_vert_24),
                            contentDescription = ""
                        )
                    }
                })
        }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxWidth()) {
                TopSearchBar()

                LazyColumn {
                    items(users.size) { index ->
                        ChatListTile(
                            userName = users[index]["user_name"].toString(),
                            lastSeen = users[index]["last_seen"].toString(),
                            profilePhoto = users[index]["Profile_photo"].toString(),
                            message = users[index]["message"].toString(),
                            unread = 0,
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ChatListTile(
    userName: String,
    profilePhoto: String,
    message: String,
    lastSeen: String,
    unread: Int,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp)
            .height(70.dp)
            .clickable(enabled = true, onClick = { navController.navigate("chats") }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(color = Color.Gray)
                .height(60.dp)
                .width(60.dp)
                .padding(end = 20.dp)

        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "$userName")
                Text(text = "$lastSeen")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "$message")
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(Color.Green)
                        .height(22.dp)
                        .width(22.dp)
                        .wrapContentSize()
                ) {
                    Text(
                        text = unread.toString(),
                        fontSize = 10.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(0.dp)
                    )
                }

            }

        }
    }
}

@Composable
fun TopSearchBar() {
    TextField(
        value = "Ask Meta AI or Search",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
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
}