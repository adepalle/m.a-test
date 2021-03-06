package fr.adepalle.ma_test.ui.main

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.adepalle.domain.usecase.RefreshAllUsers
import fr.adepalle.domain.usecase.RetrieveAllUsers
import fr.adepalle.ma_test.base.BaseViewState
import fr.adepalle.ma_test.base.EnumStateViewModel
import fr.adepalle.ma_test.base.SingleLiveEvent
import fr.adepalle.ma_test.wrapper.UserViewDataWrapper
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val retrieveAllUsers: RetrieveAllUsers,
    private val refreshAllUsers: RefreshAllUsers
) : EnumStateViewModel<BaseViewState>() {

    private val usersLiveData = SingleLiveEvent<List<UserViewDataWrapper>>()
    private val errorLiveData = SingleLiveEvent<Throwable>()

    override var currentViewState = BaseViewState.WAITING

    fun retrieveUserList() {
        updateViewState(BaseViewState.LOADING)
        retrieveAllUsers.subscribe(
            onError = {
                errorLiveData.postValue(it)
                updateViewState(BaseViewState.WAITING)
            },
            onSuccess = { userList ->
                usersLiveData.postValue(userList.map {
                    UserViewDataWrapper(it)
                })
                updateViewState(BaseViewState.WAITING)
            }
        )
    }

    fun refreshUserList() {
        updateViewState(BaseViewState.LOADING)
        refreshAllUsers.subscribe(
            onError = {
                errorLiveData.postValue(it)
                updateViewState(BaseViewState.WAITING)
            },
            onSuccess = { userList ->
                usersLiveData.postValue(userList.map {
                    UserViewDataWrapper(it)
                })
                updateViewState(BaseViewState.WAITING)
            }
        )
    }

    fun getUserListLiveEvent(): LiveData<List<UserViewDataWrapper>> = usersLiveData
    fun getErrorLiveEvent(): LiveData<Throwable> = errorLiveData
}