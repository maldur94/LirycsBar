package com.maldur94.lirycsbar.ui.lirycs.screen

import androidx.annotation.StringRes
import com.maldur94.lirycsbar.R

enum class LirycsBarScreen(@StringRes val titleId: Int) {
    Lirycs(titleId = R.string.lirycs),
    LirycsEdit(titleId = R.string.lirycs_edit)
}
