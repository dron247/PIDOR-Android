package com.applepride.pidor.model.repository;

import java.util.List;

/**
 * Created by dron on 13.03.17.
 */

public interface IExampleRepository<E> {
    List<E> getItems();

    void addListener(RepositoryChangedListener listener);

    void removeListener(RepositoryChangedListener listener);

    void addItem(String value);

    E getItem(int id);

    interface RepositoryChangedListener {
        void onChanged();
    }
}
