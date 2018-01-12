package com.example.basecore.util.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;

import com.example.basecore.R;

/**
 * Created by yuancunsun on 2018/1/12.
 */

public class UIHelper {

    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param context
     * @param spVal
     * @return
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }


    public static void startActivity(Activity activity, Class clazz, boolean isFinish) {
        activity.startActivity(new Intent(activity, clazz));
        if (isFinish) {
            activity.finish();
        }
        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    public static void startActivityWithParams(Activity activity, Class clazz, Object object, boolean isFinish) {
        activity.startActivity(new Intent(activity, clazz));
        if (isFinish) {
            activity.finish();
        }
        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }


}
