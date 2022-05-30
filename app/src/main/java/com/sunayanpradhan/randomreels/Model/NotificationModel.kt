package com.sunayanpradhan.randomreels.Model

data class NotificationModel(
    var notificationBy:String,
    var notificationAt:Long,
    var type: String,
    var reelsId:String,
    var notificationId:String,
    var reelsBy: String,
    var checkOpen:Boolean
)
{

    constructor():this(
        "",
        0,
        "",
        "",
        "",
        "",
        false
    )
}
