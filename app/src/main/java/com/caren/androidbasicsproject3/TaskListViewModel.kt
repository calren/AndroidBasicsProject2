package com.caren.androidbasicsproject3

import androidx.lifecycle.ViewModel

class TaskListViewModel : ViewModel() {

    val tasks = mutableListOf<String>()
    var positionOfTaskBeingEdited = -1






}