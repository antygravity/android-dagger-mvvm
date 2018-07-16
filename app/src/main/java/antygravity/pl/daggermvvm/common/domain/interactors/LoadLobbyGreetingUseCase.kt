package antygravity.pl.daggermvvm.common.domain.interactors

import antygravity.pl.daggermvvm.lobby.LobbyGreetingRepository
import io.reactivex.Single
import javax.inject.Inject

class LoadLobbyGreetingUseCase @Inject constructor(commonGreetingRepository: LobbyGreetingRepository) : LoadGreetingUseCase {

    private val lobbyGreetingRepository: LobbyGreetingRepository = commonGreetingRepository

    override fun execute(): Single<String> = lobbyGreetingRepository.sayHello()
}