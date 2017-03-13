package com.applepride.pidor.modules.module1.object;

import com.applepride.pidor.base.IObject;

/**
 * Example item from presentation level
 */
public final class TodoListItem implements IObject {
    int id;
    String text;

    /**
     * Create an item, this item shoul be created inside getList interactor
     *
     * @param id   unique identifier
     * @param text value of item
     */
    public TodoListItem(int id, String text) {
        this.id = id;
        this.text = text;
    }

    /**
     * Unique identifier of item
     *
     * @return integer unique identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Value of item
     *
     * @return contained text
     */
    public String getText() {
        return text;
    }
}
