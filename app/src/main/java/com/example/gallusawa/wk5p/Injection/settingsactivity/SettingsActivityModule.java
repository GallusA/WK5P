package com.example.gallusawa.wk5p.Injection.settingsactivity;



import com.example.gallusawa.wk5p.View.SettingsActivity.SettingsActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsActivityModule {

    @Provides
    SettingsActivityPresenter providerSettingsActivityPresenter(){
        return new SettingsActivityPresenter();
    }
}
