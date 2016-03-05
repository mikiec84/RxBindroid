package moe.pine.rx.bindroid.example.business.model

import moe.pine.rx.bindroid.example.business.data.ViewPath
import rx.subjects.BehaviorSubject
import rx.subjects.Subject

/**
 * ViewPathModel
 * Created by pine on 2016/03/06.
 */
class ViewPathModel {
    val viewPath: Subject<ViewPath, ViewPath> by lazy {
        BehaviorSubject.create(ViewPath.Default)
    }
}