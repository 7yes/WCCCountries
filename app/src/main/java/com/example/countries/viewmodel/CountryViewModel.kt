package com.example.countries.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.domain.GetAllUseCase
import com.example.countries.domain.model.CountryItem
import com.example.countries.ui.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase):ViewModel() {

    private val _myList = MutableLiveData<List<CountryItem>>()
    val myList: LiveData<List<CountryItem>> = _myList

    private val _state = MutableLiveData<ResultState>()
    val state: LiveData<ResultState> = _state

  fun getAll(){
      _state.value = ResultState.LOADING
      viewModelScope.launch {
          println("TAJ step1")
          try {
              val data = getAllUseCase.getAll()
              Log.d("TAJ", "data $data")
              withContext(Dispatchers.Main){
                  if(data.isNullOrEmpty()){
                     _state.value = ResultState.ERROR_CONECTION("Connection is lost")
                  }else {
                      _state.value = ResultState.SUCCESS(data)
                      println("TAJ step2 ${_myList.value}")
                  }
              }
          } catch (e:Exception){
              _state.value = ResultState.ERROR(e)
          }
      }
  }

}