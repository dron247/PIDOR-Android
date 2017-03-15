package com.applepride.pidor.modules.module2.presenter;

import com.applepride.pidor.base.IPresenter;

/**
 * Created by Андрей on 15.03.2017.
 */

public interface IModule2Presenter extends IPresenter {
    void onAddClick(String text);

    void onCancelClick();
}
