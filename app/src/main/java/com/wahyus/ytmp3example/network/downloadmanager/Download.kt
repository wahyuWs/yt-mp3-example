package com.wahyus.ytmp3example.network.downloadmanager

interface Download {
    fun downloadFile(url: String, fileName: String): Long
}