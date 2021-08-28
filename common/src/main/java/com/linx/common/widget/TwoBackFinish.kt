package com.linx.common.widget

import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.linx.common.baseData.Nav

/**
 * 点击两次返回按钮关闭app
 */
class TwoBackFinish {

    companion object {
        var mExitTime: Long = 0
    }

    fun execute(keyCode: Int, activity: ComponentActivity): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            when {
                /**
                 * 点击两次退出程序 有事件间隔，间隔内退出程序，否则提示
                 */
                (System.currentTimeMillis() - mExitTime) > 1500 -> {
                    Toast.makeText(activity, "再按一次退出程序", Toast.LENGTH_SHORT).show()
                    mExitTime = System.currentTimeMillis()
                }
                else -> {
                    Nav.twoBackFinishActivity = true
                    activity.finish()
                }
            }
            /**
             * 返回true防止事件进一步传播
             */
            return true
        }
        /**
         * 返回true防止事件进一步传播
         */
        return true
    }

}