package com.hw.game.module_sdk.data.net

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * 添加okhttpclient 拦截器，捕获添加Headers，然后修改baseUrl
 */
class BaseUrlInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //获取request
        val request:Request = chain.request()
        //从request 中获取原有的HttpUrl实例oldHttpurl
        val oldHttpUrl:HttpUrl = request.url()
        //获取request 创建者Builder
        val builder:Request.Builder = request.newBuilder()
        //request 获取Headers ，通过给定的键urlname
        val headerValues:List<String> = request.headers("urlname")
        if(headerValues.isNotEmpty()) {
            //如果有header 先将这个配置的header 删除，因此header的作用 仅作app和okhttp之间使用
            builder.removeHeader("urlname")
            //匹配获得新的BaseUrl
            val headerValue: String = headerValues.get(0)
            var newBaseUrl: HttpUrl
            if ("testurl".equals(headerValue)) {
                newBaseUrl = HttpUrl.get(Constants.BASE_URL)!!
            } else if ("testurl2".equals(headerValue)) {
                newBaseUrl = HttpUrl.get(Constants.BASE_URL)!!
            } else if ("testurl3".equals(headerValue)) {
                newBaseUrl = HttpUrl.get(Constants.BASE_URL)!!
            } else {
                newBaseUrl = oldHttpUrl
            }
            //重建新的httpurl，修改需要修改的url部分
            val newFullUrl = oldHttpUrl
                .newBuilder()
                // .scheme("https")//更换网络协议
                .host(newBaseUrl.host())//更换主机名
                .port(newBaseUrl.port())//更换端口
                .removePathSegment(0)//移除第一个参数
                .build()

            //重建这个request，通过builder.url(newFullUrl).build()；
            // 然后返回一个response至此结束修改
            Log.e("Url", "intercept: " + newFullUrl.toString());
            return chain.proceed(builder.url(newFullUrl).build())
        }else{
            return chain.proceed(builder.url(oldHttpUrl).build())
        }
    }
}