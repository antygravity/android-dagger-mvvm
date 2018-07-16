package antygravity.pl.daggermvvm.di

import antygravity.pl.daggermvvm.lobby.LobbyGreetingRepository
import dagger.Module
import dagger.Provides

@Module
class LobbyActivityModule {

    @Provides
    fun provideLobbyHelloService() = LobbyGreetingRepository()
}