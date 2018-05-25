package id.co.next_innovation.vision.util

import timber.log.Timber

fun defaultErrorHandler(): (Throwable) -> Unit = { e -> Timber.e(e) }