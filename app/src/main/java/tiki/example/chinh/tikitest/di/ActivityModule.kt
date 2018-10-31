package tiki.example.chinh.tikitest.di


import dagger.Module
import dagger.android.ContributesAndroidInjector
import tiki.example.chinh.tikitest.presentation.main.MainActivity

@Module
interface ActivityModule {
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}
