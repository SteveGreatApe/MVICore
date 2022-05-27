package com.badoo.mvicore.extension

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.functions.Consumer
import io.reactivex.subjects.Subject

fun <T> Observer<T>.asConsumer() = Consumer<T> { onNext(it) }

internal fun <T> Observable<T>.observeOnNullable(scheduler: Scheduler?): Observable<T> =
    if (scheduler != null) observeOn(scheduler) else this

internal fun <T> Observable<T>.subscribeOnNullable(scheduler: Scheduler?): Observable<T> =
    if (scheduler != null) subscribeOn(scheduler) else this

internal fun <T> Subject<T>.serializeIfNotNull(param: Any?): Subject<T> =
    if (param != null) toSerialized() else this
