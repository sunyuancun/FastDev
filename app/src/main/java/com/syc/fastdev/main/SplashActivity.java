package com.syc.fastdev.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.basecore.base.BaseHandler;
import com.example.basecore.util.ui.NetWorkUtil;
import com.example.basecore.util.ui.ToastUtil;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;

import static com.example.basecore.util.ui.NetWorkUtil.TYPE_NONE;

public class SplashActivity extends Activity implements BaseHandler.BaseHandlerCallBack {
    private final int MSGONE = 1;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (NetWorkUtil.getNetWorkStates(this) == TYPE_NONE) {
            ToastUtil.showShort(this, "请检查网络");
            this.finish();
            return;
        }
        initAdView();
        handler.sendEmptyMessageDelayed(MSGONE,5000);
    }

    private void initAdView() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(AppHelper.Google_Interstitial_id);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if (handler != null)
                    handler.sendEmptyMessage(MSGONE);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                if (handler != null)
                    handler.sendEmptyMessage(MSGONE);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });
    }

    private Handler handler = new BaseHandler<>(this);


    @Override
    public void callBack(Message msg) {
        if (msg.what == MSGONE) {
            Intent in = new Intent(SplashActivity.this, MainActivity.class);
            SplashActivity.this.startActivity(in);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeMessages(MSGONE);
            handler = null;
        }
    }
}
