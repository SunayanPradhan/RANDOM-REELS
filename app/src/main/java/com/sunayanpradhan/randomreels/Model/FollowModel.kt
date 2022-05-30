package com.sunayanpradhan.deverse.io.Models

data class FollowModel(
    var followedBy:String,
    var followedAt:Long,
)
{
    constructor():this(
        "",
        0
    )
}


