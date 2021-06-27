package fr.adepalle.ma_test.ui.detail

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.adepalle.domain.usecase.RefreshAllTaskByUserId
import fr.adepalle.domain.usecase.RetrieveAllTaskByUserId
import fr.adepalle.ma_test.base.BaseViewState
import fr.adepalle.ma_test.base.EnumStateViewModel
import fr.adepalle.ma_test.base.SingleLiveEvent
import fr.adepalle.ma_test.wrapper.TaskViewDataWrapper
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val retrieveAllTaskByUserId: RetrieveAllTaskByUserId,
    private val refreshAllTaskByUserId: RefreshAllTaskByUserId
) : EnumStateViewModel<BaseViewState>() {

    private val tasksLiveData = SingleLiveEvent<List<TaskViewDataWrapper>>()
    private val errorLiveData = SingleLiveEvent<Throwable>()

    override var currentViewState = BaseViewState.WAITING

    fun retrieveTaskList(userId: Int) {
        updateViewState(BaseViewState.LOADING)
        retrieveAllTaskByUserId.subscribe(
            onError = {
                errorLiveData.postValue(it)
                updateViewState(BaseViewState.WAITING)
            },
            onSuccess = { taskList ->
                tasksLiveData.postValue(taskList.map {
                    TaskViewDataWrapper(it)
                })
                updateViewState(BaseViewState.WAITING)
            },
            params = RetrieveAllTaskByUserId.Params(userId)
        )
    }

    fun refreshTaskList(userId: Int) {
        updateViewState(BaseViewState.LOADING)
        refreshAllTaskByUserId.subscribe(
            onError = {
                errorLiveData.postValue(it)
                updateViewState(BaseViewState.WAITING)
            },
            onSuccess = { taskList ->
                tasksLiveData.postValue(taskList.map {
                    TaskViewDataWrapper(it)
                })
                updateViewState(BaseViewState.WAITING)
            },
            params = RefreshAllTaskByUserId.Params(userId)
        )
    }

    fun getTasksListLiveEvent(): LiveData<List<TaskViewDataWrapper>> = tasksLiveData
    fun getErrorLiveEvent(): LiveData<Throwable> = errorLiveData

}