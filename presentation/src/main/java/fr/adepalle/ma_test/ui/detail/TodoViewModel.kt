package fr.adepalle.ma_test.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.adepalle.domain.model.Todo
import fr.adepalle.domain.usecase.RetrieveAllTodosByUserId
import fr.adepalle.ma_test.wrapper.TodoViewDataWrapper
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getAllTodosByUserId: RetrieveAllTodosByUserId
) : ViewModel() {

    var todosLiveData = MutableLiveData<List<TodoViewDataWrapper>>()

    fun getAllTodosByUserId(userId: Int) {
        /*viewModelScope.launch {
            getAllTodosByUserId.execute(userId, allTodosByUserIdUseCaseCallback)
        }*/
    }

    /*private val allTodosByUserIdUseCaseCallback =
        object : BaseParametrizedUseCase.Callback<List<Todo>> {
            override fun onSuccess(result: List<Todo>) {
                todosLiveData.value = result.map {
                    TodoViewDataWrapper(it)
                }
            }

            override fun onError(throwable: Throwable) {
                Log.e("AllTodosByUserIdUseCase", throwable.stackTraceToString())
                todosLiveData.value = emptyList()
            }
        }*/


}