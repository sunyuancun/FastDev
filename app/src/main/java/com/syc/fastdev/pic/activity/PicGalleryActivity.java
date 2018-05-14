package com.syc.fastdev.pic.activity;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.basecore.mvp.activity.BaseMvpActivity;
import com.example.basecore.mvp.modal.Article;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.example.basecore.util.ui.widgte.imageview.ImageTouchView;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;
import com.syc.fastdev.pic.PicPresenter;
import com.syc.fastdev.pic.PicView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PicGalleryActivity extends BaseMvpActivity<PicPresenter> implements PicView {
    ViewPager viewPager;
    private ArrayList<Article.PicInfo> picInfos = new ArrayList<>();

    @Override
    public PicPresenter createPresenter() {
        return new PicPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pic_gallery);
        this.setTitleBarVisiable(false);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        Portrait portrait = (Portrait) getIntent().getSerializableExtra("Portrait");
        getPresenter().getArticle(portrait.album_address);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(10);
        viewPager.setAdapter(new ImageViewPagerAdapter(PicGalleryActivity.this, picInfos));
    }

    @Override
    public void getPicTagList(List<PicTag> list) {

    }

    @Override
    public void getPortraitList(List<Portrait> list) {

    }


    @Override
    public void getArticle(Article article) {
        if (article != null && article.pics != null) {
            picInfos.addAll(article.pics);
        }
        viewPager.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void initResLayout(View view) {

    }


    class ImageViewPagerAdapter extends PagerAdapter {

        private LinkedList<View> recycledViews = new LinkedList<View>();
        private ArrayList<Article.PicInfo> imageList = new ArrayList<>();
        private Context context;

        public ImageViewPagerAdapter(Context context, ArrayList<Article.PicInfo> imageList) {
            this.context = context;
            this.imageList = imageList;
        }

        @Override
        public int getCount() {
            return this.imageList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView;
            if (recycledViews != null && recycledViews.size() > 0) {
                itemView = recycledViews.getFirst();
                recycledViews.removeFirst();
            } else {
                itemView = getLayoutInflater().inflate(R.layout.picker_gallery_item, null);
            }

            Article.PicInfo picInfo = imageList.get(position);
            ImageTouchView imageView = itemView.findViewById(R.id.picker_gallery_image_view);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.enable();
            Glide.with(context).load(picInfo.pic_url).placeholder(R.drawable.icon_nopic).dontAnimate().crossFade(0).into(imageView);
            container.addView(itemView);
            return itemView;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            if (object != null) {
                recycledViews.addLast((View) object);
            }
        }
    }


}
