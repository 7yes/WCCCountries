package com.example.countries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.domain.GetAllUseCase
import com.example.countries.domain.model.CountryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase):ViewModel() {

    private val _myList = MutableLiveData<List<CountryItem>>()
    val myList: LiveData<List<CountryItem>> = _myList

  fun getAll(){
      viewModelScope.launch {
          println("TAJ step1")
          _myList.value= getAllUseCase.getAll()
          println("TAJ step2 ${_myList.value}")
      }
  }

}