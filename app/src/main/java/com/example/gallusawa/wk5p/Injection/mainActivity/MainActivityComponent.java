package com.example.gallusawa.wk5p.Injection.mainActivity;



import com.example.gallusawa.wk5p.View.MainActivity.MainActivity;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface  MainActivityComponent {

    void inject(MainActivity mainActivity);
}

