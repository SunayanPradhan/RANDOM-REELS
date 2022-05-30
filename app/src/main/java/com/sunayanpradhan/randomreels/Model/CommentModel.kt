package com.sunayanpradhan.randomreels.Model

data class CommentModel(
    var commentAt:Long,
    var commentBody:String,
    var commentBy:String,
    var commentId:String,
    var commentPostId:String
)
{

    constructor():this(
        0,
        "",
        "",
        "",
        ""

        )

}
