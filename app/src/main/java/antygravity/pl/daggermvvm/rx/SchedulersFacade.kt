package antygravity.pl.daggermvvm.rx

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulersFacade {

    fun io() = Schedulers.io()

    fun computation() = Schedulers.computation()

    fun ui() = AndroidSchedulers.mainThread()
}