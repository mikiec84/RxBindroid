package moe.pine.rx.bindroid.example.business.model

import rx.subjects.BehaviorSubject

/**
 * CountModel
 * Created by pine on 2016/03/06.
 */
class CountModel {
    val count by lazy { BehaviorSubject.create(0) }

    fun increment() {
        this.count.onNext(this.count.value + 1)
    }

    fun decrement() {
        this.count.onNext(this.count.value - 1)
    }
}