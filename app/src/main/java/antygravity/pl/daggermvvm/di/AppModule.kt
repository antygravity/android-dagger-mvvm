package antygravity.pl.daggermvvm.di

import android.app.Application
import antygravity.pl.daggermvvm.common.domain.model.CommonGreetingRepository
import antygravity.pl.daggermvvm.rx.SchedulersFacade
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCommonGreetingRepository() = CommonGreetingRepository()

    @Provides
    @Singleton
    fun provideSchedulersFacade() = SchedulersFacade()


    @Provides
    @Singleton
    fun provideContext(app: Application) = app.applicationContext
}