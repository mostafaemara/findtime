package com.mse.findtime.android.ui

import androidx.compose.runtime.Composable

typealias  onAddTpe=(List<String>) -> Unit
typealias  onDismissType=()-> Unit
typealias  composeFun= @Composable ()->Unit
typealias  topBarFun =@Composable (Int)-> Unit

@Composable
fun EmptyComposable () {}