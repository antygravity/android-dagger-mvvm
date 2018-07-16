package antygravity.pl.daggermvvm

import android.app.Activity
import android.app.Application
import antygravity.pl.daggermvvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LobbyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }


    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .create()
                .inject(this)
    }
}