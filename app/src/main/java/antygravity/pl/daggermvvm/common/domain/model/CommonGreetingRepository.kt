package antygravity.pl.daggermvvm.common.domain.model

import io.reactivex.Single

class CommonGreetingRepository {
    fun sayHello(): Single<String> {
        return Single.defer {
            Thread.sleep(500) // simulate long api call
            Single.just("Hello from CommonGreetingRepository")
        }
    }
}