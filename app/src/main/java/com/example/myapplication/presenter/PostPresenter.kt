package com.example.myapplication.presenter

import com.example.myapplication.model.Post
import com.example.myapplication.service.PostAPI
import com.example.myapplication.service.PostService
import com.example.myapplication.view.AllPostsView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList

class PostPresenter {
    private val postApiInterface: PostAPI = PostService()!!.getRetrofit()!!
    private lateinit var newPostsView: AllPostsView

    fun presentAllPosts(allPostsView: AllPostsView){
        newPostsView = allPostsView
        postApiInterface.getAllPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (myObserver)
    }

    private val myObserver = object: Observer<ArrayList<Post>> {
        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: ArrayList<Post>) {
            newPostsView.displayAllPosts(t)
        }

        override fun onError(e: Throwable) {
            e.message
        }

        override fun onComplete() {
        }
    }
}

