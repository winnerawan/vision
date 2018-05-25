package id.co.next_innovation.vision.util

open class AppError : RuntimeException {

    enum class Cause {
        /** No network connection  */
        UNKNOWN_HOST,
        /** Network communication timeout  */
        TIMEOUT,
        /** Network General  */
        NETWORK,
        /** API error in general  */
        API,
        /** DB error in general  */
        DB,
        /** Other general errors  */
        ANY
    }

    private val causeType: Cause

    constructor(type: Cause = Cause.ANY) : super() {
        this.causeType = type
    }

    constructor(message: String?, type: Cause = Cause.ANY) : super(message) {
        this.causeType = type
    }

    constructor(error: Throwable?, type: Cause = Cause.ANY) : super(error) {
        this.causeType = type
    }

    constructor(message: String?, error: Throwable?, type: Cause = Cause.ANY) : super(message, error) {
        this.causeType = type
    }
}

