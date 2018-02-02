package com.syc.fastdev.pic;

import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public interface PicView extends BaseView {

    void getPicTagList(List<PicTag> list);

}
