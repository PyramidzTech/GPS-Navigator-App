package gps.map.navigator.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import gps.map.navigator.view.ui.MainActivity;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}