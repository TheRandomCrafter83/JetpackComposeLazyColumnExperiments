package com.coderz.f1.lazycolumnexperiment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    var listItems: List<User> by mutableStateOf(ArrayList())
        private set

    @JvmName("assignList")
    fun setListItems(list: ArrayList<User>) {
        listItems = list
    }

}