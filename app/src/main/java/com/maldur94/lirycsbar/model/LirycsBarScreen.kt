package com.maldur94.lirycsbar.model

import androidx.annotation.StringRes
import com.maldur94.lirycsbar.R

enum class LirycsBarScreen(@StringRes val titleId: Int) {
    Lirycs(titleId = R.string.lirycs),
    LirycsAdd(titleId = R.string.add_liryc),
    LirycsEdit(titleId = R.string.edit_lirycs)
}
