package com.example.myapplication.presenter

import android.util.Log
import com.example.myapplication.model.Post
import com.example.myapplication.service.PostAPI
import com.example.myapplication.service.PostService
import com.example.myapplication.view.AllPostsView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList

class PostPresenter {
    private val postApiInterface: PostAPI = PostService().getRetrofit()!!
    private lateinit var newPostsView: AllPostsView
    val disposables: CompositeDisposable = CompositeDisposable()

    fun presentAllPosts(allPostsView: AllPostsView){
        newPostsView = allPostsView
        postApiInterface.getAllPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (myObserver)
    }

    private val myObserver = object: Observer<ArrayList<Post>> {
        override fun onSubscribe(d: Disposable) {
            disposables.add(d)
        }

        override fun onNext(posts: ArrayList<Post>) {
            newPostsView.displayAllPosts(posts)
        }

        override fun onError(e: Throwable) {
            e.message
        }

        override fun onComplete() {
            Log.d(TAG, "Completed Now")
        }
    }

    companion object{
        const val TAG = "MainActivity"
    }
}

