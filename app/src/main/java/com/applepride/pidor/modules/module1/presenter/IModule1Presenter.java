package com.applepride.pidor.modules.module1.presenter;

import com.applepride.pidor.base.IPresenter;

/**
 * Created by Андрей on 13.03.2017.
 */

public interface IModule1Presenter extends IPresenter {
    void loadItems();

    void onNavigateAway();

    void onShowExampleDialog();
}
