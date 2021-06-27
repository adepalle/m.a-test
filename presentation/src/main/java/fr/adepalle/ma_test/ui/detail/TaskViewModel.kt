package fr.adepalle.ma_test.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.adepalle.domain.usecase.RetrieveAllTaskByUserId
import fr.adepalle.ma_test.wrapper.TaskViewDataWrapper
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getAllTasksByUserId: RetrieveAllTaskByUserId
) : ViewModel() {

    var tasksLiveData = MutableLiveData<List<TaskViewDataWrapper>>()


}