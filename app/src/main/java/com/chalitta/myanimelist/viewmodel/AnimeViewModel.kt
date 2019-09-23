package com.chalitta.myanimelist.viewmodel

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import com.chalitta.myanimelist.R
import com.chalitta.myanimelist.activity.HistoryActivity
import com.chalitta.myanimelist.adapter.AnimelistAdapter
import com.chalitta.myanimelist.repository.AnimeLiveData
import com.chalitta.myanimelist.model.DataAnime
import com.chalitta.myanimelist.repository.Constant
import com.chalitta.myanimelist.room.AppDatabase
import com.chalitta.myanimelist.room.HistoryEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_history.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.filter
import java.util.concurrent.TimeUnit

class AnimeViewModel(constants: Constant,val appDatabase: AppDatabase) : ViewModel() {

    val TAG = "AnimeViewModel"
    val adapter = AnimelistAdapter()
    val animeLiveData by lazy { AnimeLiveData(constants.BASE_URL) }

    internal fun setAdapterList(it:DataAnime){
        adapter.animeList = it.recommendations
        adapter.notifyDataSetChanged()
    }

    fun fetchData(lifecycleOwner: LifecycleOwner) {
            animeLiveData.observe(lifecycleOwner, Observer { anime ->
                anime?.let {
                    Log.d(TAG, "has data : " + it.recommendations.size)
                    setAdapterList(it)
                }
            })
    }

    fun onTextChanged(et_search :  EditText) : Observable<String>{
        return Observable.create {
            val textWatcher = object : TextWatcher{
                override fun afterTextChanged(s: Editable?) = Unit
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    s?.let {srt ->
                        it.onNext(srt.toString())
                    }
                }

            }
            et_search.addTextChangedListener(textWatcher)
            it.setCancellable {
                et_search.removeTextChangedListener(textWatcher)
            }
        }

    }

    fun initSearch(etSearch: EditText) {
        onTextChanged(etSearch).let { textWatch ->
            textWatch.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .filter { it.length  == 6 }
                    .debounce(1000, TimeUnit.MILLISECONDS)
                    .subscribe {
                        Log.d(TAG, "StringTextWatch : $it")
                        addHistory(it)
                    }
        }
    }

    fun addHistory(it: String) {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault())
        val currentDate = sdf.format(Date())

        val data = HistoryEntity(textSearch = it, dateSearch = currentDate)

        Flowable.fromCallable { appDatabase.historyDao().insertHistory(data) }?.let { histoty ->
            histoty.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.d(TAG, "Insert Success!")
                    },
                            { error ->
                                Log.d(TAG, "Insert Fail!")
                            })
        }
    }

    fun showHistory(v: View){
        val intent = Intent(v.context, HistoryActivity::class.java)
        v.context.startActivity(intent)
    }

    fun getHistory(lv_history: ListView)  {
        Flowable.fromCallable { appDatabase.historyDao().getHistoryAll()}?.let {histoty ->
            histoty.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { list -> list.map { it.textSearch } }
                    .subscribe {
                        lv_history.adapter = ArrayAdapter<String>(lv_history.context, R.layout.support_simple_spinner_dropdown_item, it)
                    }
        }
    }

}