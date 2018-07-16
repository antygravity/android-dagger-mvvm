package antygravity.pl.daggermvvm.common.viewmodel

class Response(var status: Status, var data: String? = null, error: Throwable? = null) {

    companion object {

        fun loading() = Response(Status.LOADING)

        fun success(data: String?) = Response(Status.SUCCESS, data)

        fun error(error: Throwable?) = Response(Status.ERROR, null, error)
    }
}