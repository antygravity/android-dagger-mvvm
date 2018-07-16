package antygravity.pl.daggermvvm.lobby

import io.reactivex.Single

class LobbyGreetingRepository {

    fun sayHello(): Single<String> {
        return Single.defer {
            Thread.sleep(1000) // simulate long api call
            Single.just("Hello from LobbyGreetingRepository")
        }
    }
}