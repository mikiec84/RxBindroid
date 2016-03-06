package moe.pine.rx.bindroid.example.business

import moe.pine.rx.bindroid.example.business.model.CountModel
import moe.pine.rx.bindroid.example.business.model.ViewPathModel

/**
 * Models
 * Created by pine on 2016/03/06.
 */
object Models {
    val viewPath by lazy { ViewPathModel() }
    val count by lazy { CountModel() }
}