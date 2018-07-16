package antygravity.pl.daggermvvm.lobby

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import antygravity.pl.daggermvvm.common.domain.interactors.LoadGreetingUseCase
import antygravity.pl.daggermvvm.common.domain.interactors.LoadLobbyGreetingUseCase
import antygravity.pl.daggermvvm.common.viewmodel.Response
import antygravity.pl.daggermvvm.rx.SchedulersFacade
import io.reactivex.disposables.CompositeDisposable

class LobbyViewModel(private var loadCommonGreetingUseCase: LoadCommonGreetingUseCase, private var loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase, private var schedulersFacade: SchedulersFacade) : ViewModel() {

    var response: MutableLiveData<Response> = MutableLiveData()
    private var disposables: CompositeDisposable = CompositeDisposable()

    private fun loadGreeting(loadGreetingUseCase: LoadGreetingUseCase) {
        disposables.add(loadGreetingUseCase.execute()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe { _ -> response.value = Response.loading() }
                .subscribe(
                        { greeting -> response.value = Response.success(greeting) },
                        { error -> response.value = Response.error(error) })
        )
    }

    fun loadCommonGreeting() {
        val start = System.currentTimeMillis()
        loadGreeting(loadCommonGreetingUseCase)
        val elapsed = System.currentTimeMillis() - start
        println("loadCommonGreeting:$elapsed")
    }

    fun loadLobbyGreeting() {
        val start = System.currentTimeMillis()
        loadGreeting(loadLobbyGreetingUseCase)
        val elapsed = System.currentTimeMillis() - start
        println("loadLobbyGreeting:$elapsed")
    }

    override fun onCleared() {
        disposables.clear()
    }
}