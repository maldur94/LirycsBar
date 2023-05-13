package com.maldur94.lirycsbar.model

import com.maldur94.database.model.Liryc

interface LirycActions {
    fun addLiryc(liryc: Liryc)
    fun editLiryc(liryc: Liryc)
    fun removeLiryc(liryc: Liryc)
}
