package antygravity.pl.daggermvvm.lobby

import antygravity.pl.daggermvvm.common.domain.interactors.LoadLobbyGreetingUseCase
import antygravity.pl.daggermvvm.rx.SchedulersFacade
import dagger.Module
import dagger.Provides

@Module
class LobbyModule {

    @Provides
    fun provideLobbyGreetingRepository() = LobbyGreetingRepository()

    @Provides
    fun provideLobbyViewModelFactory(loadCommonGreetingUseCase: LoadCommonGreetingUseCase, loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase, schedulersFacade: SchedulersFacade): LobbyViewModelFactory {
        return LobbyViewModelFactory(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade)
    }
}