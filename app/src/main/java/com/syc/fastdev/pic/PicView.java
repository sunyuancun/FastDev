package com.syc.fastdev.pic;

import com.example.basecore.mvp.modal.Article;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.example.basecore.mvp.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public interface PicView extends BaseView {

    void getPicTagList(List<PicTag> list);
    void getPortraitList(List<Portrait> list);
    void getArticle(Article article);
}
