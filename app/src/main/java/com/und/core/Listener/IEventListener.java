package com.und.core.Listener;

/**
 * Created by hungle on 01/03/2019.
 */

public interface IEventListener<T> {
    void OnAdapterItemClick(T data, int position);
}
