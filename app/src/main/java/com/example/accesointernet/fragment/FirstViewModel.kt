package com.example.accesointernet.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accesointernet.network.ColorApi
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    private var _texto = MutableLiveData<String>()
    val texto: LiveData<String>
        get() = _texto

    private var orden: Int = 0

    init {
        getDatos()
    }

    private fun getDatos() {
        viewModelScope.launch {
            try {
                var listResult = ColorApi.retrofitService.getProperties()
                orden = (0..listResult.size).random()
                _texto.value = "La id del color es: \n${listResult[orden].id} , la id del " +
                        "usuario que está usando el color es: ${listResult[orden].userId}, " +
                        "el título de la obra que usa el color es " +
                        "al ${listResult[orden].title}. Y el cuerpo de la obra que se usa es " +
                        "${listResult[orden].body}.\n\n."

            } catch (e: Exception) {
                _texto.value = "Error: ${e.message}"
            }
        }
    }
}