package com.example.customviewwithmvvm

import androidx.databinding.Bindable
import androidx.lifecycle.*

class HomeViewModel
constructor() : ObservableViewModel(), LifecycleObserver {
    @Bindable
    val text = MutableLiveData("Hello world")
    @Bindable
    val color = MutableLiveData("green")
}