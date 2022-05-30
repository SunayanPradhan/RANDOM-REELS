package com.sunayanpradhan.randomreels.Model

data class SavedModel(var savedReel:String,var savedAt:Long)
{
    constructor():this(
    "",
        0
    )
}
