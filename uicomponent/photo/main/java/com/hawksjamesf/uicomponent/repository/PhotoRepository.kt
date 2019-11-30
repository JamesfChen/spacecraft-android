package com.hawksjamesf.uicomponent.repository

import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Nov/24/2019  Sun
 */
interface PhotoRepository {


    fun getNetworkApi(): NetworkApi

    fun getAny():LiveData<PagedList<String>>?
}

class PhotoRepositoryImpl(private val region: CacheRegion) : PhotoRepository {
    companion object {
        private val DISK_IO = Executors.newSingleThreadExecutor()
        private val NETWORK_IO = Executors.newFixedThreadPool(3)
    }

    lateinit var dataSourceFactory: PhotoDataSourceFactory
    var executor: Executor
    private val api by lazy {
        NetworkApi.create()
    }

    init {

        executor = when (region) {
            CacheRegion.IN_MEMORY_BY_PAGE -> {
                NETWORK_IO
            }
            CacheRegion.IN_MEMORY_BY_ITEM -> {
                NETWORK_IO
            }
            CacheRegion.IN_DB -> {
                DISK_IO
            }
        }
    }

    override fun getNetworkApi() = api

    override fun getAny():LiveData<PagedList<String>>?{
        dataSourceFactory = PhotoDataSourceFactory(region, api)
        val toLiveData = dataSourceFactory.toLiveData(
                config = Config(
                        pageSize = 30,
                        enablePlaceholders = false,
                        initialLoadSizeHint = 30 * 2),
                fetchExecutor = executor)

//        dataSourceFactory.sourceLiveData?.value?.invalidate()
        return toLiveData
    }

}