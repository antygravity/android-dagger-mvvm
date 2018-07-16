package antygravity.pl.daggermvvm.lobby

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import antygravity.pl.daggermvvm.common.domain.interactors.LoadLobbyGreetingUseCase
import antygravity.pl.daggermvvm.rx.SchedulersFacade

class LobbyViewModelFactory(private val loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
                            private val loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
                            private val schedulersFacade: SchedulersFacade) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LobbyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LobbyViewModel(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}