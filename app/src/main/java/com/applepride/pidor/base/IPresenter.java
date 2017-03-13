package com.applepride.pidor.base;

/**
 * Created by Андрей on 07.03.2017.
 */

public interface IPresenter {
    <E extends IDecorator> void bind(E decorator);

    void unbind();

    boolean isAttached();
}
