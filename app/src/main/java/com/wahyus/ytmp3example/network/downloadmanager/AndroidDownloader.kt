package com.wahyus.ytmp3example.network.downloadmanager

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import android.webkit.MimeTypeMap
import androidx.core.net.toUri
import java.io.File

class AndroidDownloader(context: Context): Download {
    private val downloadManager = context.getSystemService(DownloadManager::class.java)
    override fun downloadFile(url: String, fileName: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("audio/mpeg")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            .setTitle(fileName)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "$fileName.mp3")
        return downloadManager.enqueue(request)
    }
}