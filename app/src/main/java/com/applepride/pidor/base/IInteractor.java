package com.applepride.pidor.base;

/**
 * Created by Андрей on 07.03.2017.
 */

public interface IInteractor<E, F> {
    void perform(E param, InteractorListener<F> callback);
}
