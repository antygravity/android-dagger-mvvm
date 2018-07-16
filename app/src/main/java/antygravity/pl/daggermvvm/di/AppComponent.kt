package antygravity.pl.daggermvvm.di

import antygravity.pl.daggermvvm.LobbyApplication
import antygravity.pl.daggermvvm.lobby.LobbyModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (LobbyModule::class), (BuildersModule::class)])
interface AppComponent {
    fun inject(app: LobbyApplication)
}