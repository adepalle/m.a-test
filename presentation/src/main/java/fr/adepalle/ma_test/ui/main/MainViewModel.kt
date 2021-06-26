package fr.adepalle.ma_test.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.adepalle.domain.model.User
import fr.adepalle.domain.usecase.RetrieveAllUsers
import fr.adepalle.domain.usecase.base.BaseUseCase
import fr.adepalle.ma_test.wrapper.UserViewDataWrapper
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUsers: RetrieveAllUsers
) : ViewModel() {

    var usersLiveData = MutableLiveData<List<UserViewDataWrapper>>()

    private val allUsersUseCaseCallback = object : BaseUseCase.Callback<List<User>> {
        override fun onSuccess(result: List<User>) {
            usersLiveData.value = result.map {
                UserViewDataWrapper(it)
            }

        }

        override fun onError(throwable: Throwable) {
            Log.e("AllUserUseCase", throwable.stackTraceToString())
            usersLiveData.value = emptyList()
        }
    }

    fun getAllUsers() {
        viewModelScope.launch {
            getAllUsers.execute(allUsersUseCaseCallback)
        }
    }

}