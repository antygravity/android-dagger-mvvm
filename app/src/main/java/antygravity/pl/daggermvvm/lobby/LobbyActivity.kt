package antygravity.pl.daggermvvm.lobby

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import antygravity.pl.daggermvvm.R
import antygravity.pl.daggermvvm.common.viewmodel.Response
import antygravity.pl.daggermvvm.common.viewmodel.Status
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import dagger.android.AndroidInjection
import javax.inject.Inject

class LobbyActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: LobbyViewModelFactory


    @BindView(R.id.text_hello)
    lateinit var textHello: TextView

    @BindView(R.id.progress_bar)
    lateinit var progressBar: ProgressBar

    private lateinit var lobbyViewModel: LobbyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        lobbyViewModel = ViewModelProviders.of(this, viewModelFactory).get(LobbyViewModel::class.java)
        lobbyViewModel.response.observe(this, Observer { response -> this.processResponse(response) })
    }

    @OnClick(R.id.common_greeting_button)
    fun onCommonClick() = lobbyViewModel.loadCommonGreeting()


    @OnClick(R.id.lobby_greeting_button)
    fun onLobbyClick() = lobbyViewModel.loadLobbyGreeting()

    private fun processResponse(response: Response?) {
        when (response?.status) {
            Status.LOADING -> renderLoadingState()
            Status.ERROR -> renderErrorState()
            Status.SUCCESS -> renderSuccessState(response.data)
        }
    }

    private fun renderSuccessState(greeting: String?) {
        progressBar.visibility = View.GONE
        textHello.visibility = View.VISIBLE
        textHello.text = greeting

    }

    private fun renderErrorState() {
        progressBar.visibility = View.GONE
        textHello.visibility = View.GONE
        Toast.makeText(this, "Unable to load greeting.", Toast.LENGTH_SHORT).show()
    }

    private fun renderLoadingState() {
        progressBar.visibility = View.VISIBLE
        textHello.visibility = View.GONE
    }
}
