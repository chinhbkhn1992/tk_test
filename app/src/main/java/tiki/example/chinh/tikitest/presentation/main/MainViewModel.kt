package tiki.example.chinh.tikitest.presentation.main

import android.content.Context
import android.databinding.BaseObservable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import tiki.example.chinh.tikitest.data.ApiService
import javax.inject.Inject

class MainViewModel @Inject constructor(val context: Context, val api: ApiService) : BaseObservable() {

    private val compositeDisposable = CompositeDisposable()
    var view: MainView? = null
    fun loadKeywords() {
        api.getKeywords().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            {
                view?.onLoadKeywords(it)
            }, {
                print(it)
            }
        )
            .addTo(compositeDisposable)

    }
}