package com.jamesfchen.myhome.screen.photo

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.widget.HorizontalScrollView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.google.firebase.perf.metrics.AddTrace
import com.jamesfchen.myhome.screen.photo.vm.PhotoListViewModel
import com.jamesfchen.myhome.screen.photo.repository.CacheRegion
import com.jamesfchen.myhome.screen.photo.repository.ServiceLocator
import com.jamesfchen.myhome.widget.ImageListView
import jamesfchen.widget.Divider
import kotlinx.coroutines.flow.collectLatest

class PhotoListActivity : AppCompatActivity() {
    lateinit var rvPhotoList: RecyclerView
    private val viewModel by viewModels<PhotoListViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repo = ServiceLocator.instance(this@PhotoListActivity)
                    .getPhotoRepository(CacheRegion.IN_MEMORY_BY_PAGE)
                return PhotoListViewModel(application, repo) as T
            }
        }
    }

    @AddTrace(name = "PhotoListActivity#onCreate", enabled = true)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ImageListView(this)

        //init view
        rvPhotoList = RecyclerView(this)
        rvPhotoList.setBackgroundColor(Color.CYAN)
        rvPhotoList.layoutManager = LinearLayoutManager(this)
        rvPhotoList.addItemDecoration(Divider(this))

        val adapter = PhotoListAdapter(this)
//        val headerAdapter = HeaderAdapter()
//        val footerAdapter = FooterAdapter()
//        val concatAdapter = adapter.withLoadStateHeaderAndFooter(headerAdapter, footerAdapter)
        val concatAdapter = adapter
        rvPhotoList.adapter = concatAdapter
//        val preloader = RecyclerViewPreloader(adapter.glideRequestBuilder, adapter, adapter, 4)
//        rvPhotoList.addOnScrollListener(preloader)
//        rvPhotoList.addRecyclerListener { holder ->
//            (holder.itemView as HorizontalScrollView).children.forEach {
//                adapter.glideRequestBuilder.clear(it)
//            }
//        }
        //有固定的size
//        rvPhotoList.setHasFixedSize(true)
//        rvPhotoList.setOnTouchListener { view, motionEvent ->
////            MatrixLog.i("TestPluginListener", "onTouch=$motionEvent")
//            SystemClock.sleep(80)
//            return@setOnTouchListener false
//        }
        setContentView(rvPhotoList)
        lifecycleScope.launchWhenCreated { }

        //init data

//        ItemTouchHelper(object : ItemTouchHelper.Callback() {
//            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
//                    makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
//
//            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = false
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
////                viewModel.itemList?.value?.remove(viewHolder.itemView.tag)
//            }
//        }).attachToRecyclerView(rvPhotoList)
//        val observer = Observer(adapter::submitList)
        lifecycleScope.launchWhenResumed {
            viewModel.allImages.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }

    @AddTrace(name = "PhotoListActivity#onStart", enabled = true)
    override fun onStart() {
        super.onStart()
    }

    @AddTrace(name = "PhotoListActivity#onResume", enabled = true)
    override fun onResume() {
        super.onResume()
    }
}
