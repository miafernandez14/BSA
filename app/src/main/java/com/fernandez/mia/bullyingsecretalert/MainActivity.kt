package com.fernandez.mia.bullyingsecretalert

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){
    private lateinit var videoView: VideoView
    private var ourRequestCode : Int=123
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView=findViewById(R.id.videoView)

        val mediCollection = MediaController(this)
        mediCollection.setAnchorView(videoView)
        videoView.setMediaController(mediCollection)
    }

    fun startVideo(view: View) {
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        if(intent.resolveActivity(packageManager)!=null){
            startActivityForResult(intent,ourRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ourRequestCode && resultCode == RESULT_OK){
            val videoUri=data?.data
            videoView.setVideoURI(videoUri)
            videoView.start()
        }



    }



}