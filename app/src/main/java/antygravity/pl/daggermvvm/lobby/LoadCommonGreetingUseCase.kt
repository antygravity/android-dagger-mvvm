package antygravity.pl.daggermvvm.lobby

import antygravity.pl.daggermvvm.common.domain.interactors.LoadGreetingUseCase
import antygravity.pl.daggermvvm.common.domain.model.CommonGreetingRepository
import io.reactivex.Single
import javax.inject.Inject

class LoadCommonGreetingUseCase @Inject constructor(private val commonGreetingRepository: CommonGreetingRepository) : LoadGreetingUseCase {

    override fun execute(): Single<String> = commonGreetingRepository.sayHello()
}