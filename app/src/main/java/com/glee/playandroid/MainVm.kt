package com.glee.playandroid

import android.app.Application
import android.util.Log
import com.glee.libbase.bean.ArticleBean
import com.glee.libbase.recycler.ObservableArrayListProxy
import com.glee.libbase.util.BaseVmWithRefresh

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 4:32 PM
 */
class MainVm constructor(app: Application) : BaseVmWithRefresh(app) {
//    @SuppressLint("SwitchIntDef")
//    override fun onAction(view: View, action: Int, position: Int) =
//            when (action) {
//                Action.CLICK -> {
//                    toast(app, "点击了$position")
//                }
//                Action.LONG_CLICK -> {
//
//                }
//                Action.REFRESH -> {
//
//                    toast(app, "刷新了$position")
//                }
//                Action.LOAD_MORE -> {
//
//                    toast(app, "加载$position")
//                }
//                else -> {
//
//                }
//            }


    private var pageNum = 3

    val recyclerData by lazy {
        ObservableArrayListProxy<ArticleBean.DatasBean>(BR.data)
    }

//    val recyclerItemClick by lazy {
//        OnItemClickListener { view, position ->
//            toast(app, position.toString() + view.toString())
//        }
//    }

    override fun onLoadMore() {
        pageNum++
        du()
    }

    override fun onRefresh() {
        du()
    }

    private fun getUrl() = "http://www.wanandroid.com/article/list/$pageNum/json"

//    override fun onRefresh(refreshLayout: RefreshLayout) {
//        super.onRefresh(refreshLayout)
//        du()
//    }
//
//    override fun onLoadMore(refreshLayout: RefreshLayout) {
//        super.onLoadMore(refreshLayout)
//        toast(app, "哈哈")
//    }

    init {
        du()
    }

    private fun du() {
        net.getMainList(getUrl())
                .doOnDispose {
                    Log.d("glee9507", "duan le ")
                }
                .io2main()
                .with(this)
                .subscribe(
                        start = { Log.d("glee9507", "kaishi") },
                        success = {
                            recyclerData.addAll(it.data.datas)
                            showContent()
                            finishLoadMore(true)
                            finishRefresh(true)
                        },
                        error = {
                            showError()
                        })
    }

}