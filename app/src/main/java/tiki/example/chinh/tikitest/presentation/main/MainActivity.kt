package tiki.example.chinh.tikitest.presentation.main

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import dagger.android.support.DaggerAppCompatActivity
import tiki.example.chinh.tikitest.R
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainView {
    @Inject
    lateinit var viewModel: MainViewModel

    val rcvKeywords: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_keywords)
    }

    val adapter: KeywordAdapter = KeywordAdapter()

    override fun onLoadKeywords(keyWords: List<String>) {
        adapter.updateList(keyWords)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcvKeywords.adapter = adapter
        rcvKeywords.addItemDecoration(DividerItemDecoration(this, LinearLayout.HORIZONTAL).apply {
            setDrawable(ContextCompat.getDrawable(this@MainActivity, R.drawable.divider_white)!!)
        })
        viewModel.view = this
        viewModel.loadKeywords()

    }
}
