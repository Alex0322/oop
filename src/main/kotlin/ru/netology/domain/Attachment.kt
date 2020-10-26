package ru.netology.domain

abstract open class Attachment(
    var id: Int = 0,
    val album_id: Int = 0,
    val owner_id: Int = 0,
    val user_id: Int = 0
) {

}

class Photo(val orientation: Int = 0) {}

class PhotoAttachment(val photo: Photo) : Attachment() {}

class Audio(val name: String = "", val artist: String = "") {}

class AudioAttachment(val audio: Audio) : Attachment() {}

class Video(val lengthSecs: Int = 0) {}

class VideoAttachment(val video: Video) : Attachment() {}

class Doc(val author: String = "") {}

class DocAttachment(val doc: Doc) : Attachment() {}

class Good(val name: String = "", val count: Int = 0) {}

class GoodAttachment(val good: Good) : Attachment() {}

