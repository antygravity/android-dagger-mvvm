package antygravity.pl.daggermvvm.di

import antygravity.pl.daggermvvm.lobby.LobbyActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Binds all sub-components within the app.
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(LobbyActivityModule::class))
    abstract fun bindMainActivity(): LobbyActivity
}