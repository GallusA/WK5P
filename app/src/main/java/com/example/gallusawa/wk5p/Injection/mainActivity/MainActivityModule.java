package com.example.gallusawa.wk5p.Injection.mainActivity;



import com.example.gallusawa.wk5p.View.MainActivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter providerMainActivityPresenter(){return new MainActivityPresenter();
    }
}
