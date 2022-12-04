package ru.netology

sealed class Attachment(val type: String)


data class AudioAttachment(
    val data: Audio
) : Attachment("audio")

data class VideoAttachment(
    val data: Video
) : Attachment("video")

data class PhotoAttachment(
    val data: Photo
) : Attachment("photo")

data class GraffitiAttachment(
    val data: Graffiti
) : Attachment("graffiti")

data class AppAttachment(
    val data: App
) : Attachment("app")

data class Audio(
    val id: Int,
    val albumID: Int,
    val ownerID: Int,
    val userID: Int
)

data class Graffiti(
    val id: Int,
    val ownerID: Int,
    val photo130: String,
    val photo604: String,
)

data class App(
    val id: Int,
    val name: String,
    val photo130: String,
    val photo604: String,
)

data class Video(
    val id: Int,
    val albumID: Int,
    val ownerID: Int,
    val userID: Int
)

data class Photo(
    val id: Int,
    val albumID: Int,
    val ownerID: Int,
    val userID: Int,
    val text: String,
    val date: Int,
    val sizes: Array<photoSizes>?,
    val width: Int,
    val height: Int
)

data class photoSizes(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)