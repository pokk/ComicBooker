package com.no1.taiwan.comicbooker.widget.dialog

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devrapid.dialogbuilder.support.QuickDialogFragment
import com.no1.taiwan.comicbooker.widget.R

class LoadingDialog {
    companion object {
        fun getinstance(fragment: Fragment): QuickDialogFragment {
            return QuickDialogFragment.Builder(fragment) {
                viewResCustom = R.layout.dialog_loading
            }.build()
        }

        fun getinstance(activity: AppCompatActivity): QuickDialogFragment {
            return QuickDialogFragment.Builder(activity) {
                viewResCustom = R.layout.dialog_loading
            }.build()
        }
    }
}
