package com.linx.playAndroid.service

import com.linx.net.base.NetUrl
import com.linx.net.paging.CommonalityPageModel
import com.linx.playAndroid.model.UserArticleListData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 广场页面网络请求接口
 */
interface SquareService {

    //广场数据
    @GET(NetUrl.USER_ARTICLE_LIST)
    suspend fun getUserArticleList(@Path("page") page: Int): CommonalityPageModel<UserArticleListData>

}