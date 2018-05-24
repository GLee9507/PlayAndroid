package com.glee.playandroid

import android.content.Context
import android.widget.Toast
import com.glee.libbase.util.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 4:20 PM
 */

//fun <T> Call<T>.ktEnqueue(vm: BaseViewModel, success: (T) -> Unit, error: (Throwable) -> Unit) {
//    vm.addCall(this)
//    enqueue(object : Callback<T> {
//        override fun onFailure(call: Call<T>?, t: Throwable) {
//            error.invoke(t)
//            vm.removeCall(this@ktEnqueue)
//        }
//
//        override fun onResponse(call: Call<T>?, response: Response<T>) {
//            val body = response.body()
//            if (body == null) {
//                error.invoke(Throwable("null"))
//            } else {
//                success.invoke(body)
//            }
//            vm.removeCall(this@ktEnqueue)
//        }
//
//    })
//}
//
//fun <T> Call<T>.ktEnqueue(start: () -> BaseViewModel, success: (T) -> Unit, error: (Throwable) -> Unit) {
////    vm.addCall(this)
//    val viewModel = start.invoke()
//    viewModel.addCall(this)
//    enqueue(object : Callback<T> {
//        override fun onFailure(call: Call<T>?, t: Throwable) {
//            error.invoke(t)
//            viewModel.removeCall(this@ktEnqueue)
//        }
//
//        override fun onResponse(call: Call<T>?, response: Response<T>) {
//            val body = response.body()
//            if (body == null) {
//                error.invoke(Throwable("null"))
//            } else {
//                success.invoke(body)
//            }
//            viewModel.removeCall(this@ktEnqueue)
//        }
//
//    })
//}

/**
 * 线程调度
 */
fun <T> Observable<T>.io2main(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.subscribe(start: (() -> Unit) = {}, success: (T) -> Unit, error: (Throwable) -> Unit, finish: () -> Unit = {}) {
    doOnSubscribe { start.invoke() }
            .doFinally(finish)
            .subscribe(success, error)
}

//fun <T> Observable<T>.subscribe(success: (T) -> Unit, error: (Throwable) -> Unit) {
//    subscribe(success, error)
//}

//fun <T> Observable<T>.subscribe(start: () -> Unit, success: (T) -> Unit, error: (Throwable) -> Unit) {
//    subscribe(success, error)
//}


/**
 * 生命周期
 */
fun <T> Observable<T>.with(vm: BaseViewModel): Observable<T> {
//    var disposable: Disposable? = null

    return doOnSubscribe {
        //        disposable = it
        vm.compositeDisposable.add(it)
    }
//            .doOnComplete {
//        disposable?.let {
//            vm.compositeDisposable.remove(it)
//        }
//    }
}

fun toast(application: Context, string: String) {
    Toast.makeText(application, string, Toast.LENGTH_LONG).show()
}