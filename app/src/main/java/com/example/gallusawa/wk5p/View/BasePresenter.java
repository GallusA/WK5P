package com.example.gallusawa.wk5p.View;


public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void detachView();
}
