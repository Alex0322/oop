package ru.netology.domain

abstract class Attachment(
    open val type: String = ""
) {}

data class Photo(
    var id: Int = 0,
    val album_id: Int = 0,
    val owner_id: Int = 0,
    val user_id: Int = 0
) {}

data class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo = Photo()
) : Attachment() {} // рискну предположить, что круглые скобки, всё-таки, нужны, иначе - не компилируется

data class Audio(
    var id: Int = 0,
    val album_id: Int = 0,
    val owner_id: Int = 0,
    val user_id: Int = 0
) {}


data class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio = Audio()
) : Attachment() {}

data class Video(
    var id: Int = 0,
    val album_id: Int = 0,
    val owner_id: Int = 0,
    val user_id: Int = 0
) {}

data class VideoAttachment(
    override val type: String = "video",
    val video: Video = Video()
) : Attachment() {}

data class Doc(
    var id: Int = 0,
    val album_id: Int = 0,
    val owner_id: Int = 0,
    val user_id: Int = 0
) {}

data class DocAttachment(
    override val type: String = "doc",
    val doc: Doc = Doc()
) : Attachment() {}

data class Good(
    var id: Int = 0,
    val album_id: Int = 0,
    val owner_id: Int = 0,
    val user_id: Int = 0
) {}

data class GoodAttachment(
    override val type: String = "good",
    val good: Good = Good()
) : Attachment() {}

