package com.coderz.f1.lazycolumnexperiment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayList(users: ArrayList<User>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(users) { _, user ->
            ItemCard(user)
        }
    }
}

@Composable
fun ItemCard(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        RoundedCornerShape(4.dp),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(user.username, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                user.emailAddress,
                fontSize = 16.sp,
                color = Color.LightGray,
                fontStyle = FontStyle.Italic
            )
        }
    }
}