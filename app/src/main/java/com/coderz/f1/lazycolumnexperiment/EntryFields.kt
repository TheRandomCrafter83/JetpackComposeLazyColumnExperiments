package com.coderz.f1.lazycolumnexperiment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

val userNameFocusRequester: FocusRequester = FocusRequester()
val emailFocusRequester: FocusRequester = FocusRequester()

@Composable
fun EntryFields(onAddClick: (user: User) -> Unit) {
    var nameField: String by remember { mutableStateOf(String()) }
    var emailField: String by remember { mutableStateOf(String()) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    )
    {
        Row(modifier = Modifier
            .fillMaxSize()
            .height(IntrinsicSize.Min)) {
            Column(modifier = Modifier
                .fillMaxWidth(.8f)
                .padding(8.dp)
                .height(IntrinsicSize.Min)) {

                TextField(nameField,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(userNameFocusRequester),
                    onValueChange = {
                        nameField = it
                    },
                    placeholder = {
                        Text("Username")
                    },
                    label = {
                        Text("Username")
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            emailFocusRequester.requestFocus()
                        }
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    }
                )
                Spacer(modifier = Modifier.height(2.dp))
                TextField(emailField,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(emailFocusRequester),
                    onValueChange = {
                        emailField = it
                    },
                    placeholder = {
                        Text("Email Address")
                    },
                    label = {
                        Text("Email Address")
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Email
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            val user = User(username = nameField, emailAddress = emailField)
                            onAddClick(user)
                            nameField = ""
                            emailField = ""
                            userNameFocusRequester.requestFocus()
                        }
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Email,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .height(IntrinsicSize.Min),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                IconButton(modifier = Modifier
                    .width(48.dp)
                    .height(48.dp), onClick = {
                    val user = User(username = nameField, emailAddress = emailField)
                    onAddClick(user)
                    nameField = ""
                    emailField = ""
                    userNameFocusRequester.requestFocus()
                }) {
                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Add",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}