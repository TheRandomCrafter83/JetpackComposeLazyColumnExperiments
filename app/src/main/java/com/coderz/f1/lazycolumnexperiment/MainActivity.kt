package com.coderz.f1.lazycolumnexperiment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.coderz.f1.lazycolumnexperiment.ui.theme.LazyColumnExperimentTheme

private val Colors.LightGray: Color
    get() {
        return Color.LightGray
    }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnExperimentTheme {
                var listItems by remember { mutableStateOf<List<User>>(ArrayList()) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        EntryFields(onAddClick = { user ->
                            listItems = listItems + listOf(user)
                        })

                        DisplayList(
                            listItems as ArrayList<User>,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.LightGray)
                        )
                    }
                }
            }
        }
    }
}


