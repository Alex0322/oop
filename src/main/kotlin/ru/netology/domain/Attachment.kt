package ru.netology.domain

abstract class Attachment(
    var id: Int = 0,
    val album_id: Int = 0,
    val owner_id: Int = 0,
    val user_id: Int = 0
) {
    //- class Attachment: открытое свойство a_type в базовом классе
    abstract val a_type: Int

}

//- перечисление AttachTypes с типами вложений
enum class AttachTypes() {
    PHOTO, AUDIO, VIDEO, DOC, GOOD
}

class Photo(val orientation: Int = 0) {}

class PhotoAttachment(val photo: Photo) : Attachment() {
    //- абстрактное свойство a_type переопределяется потомками
    override val a_type: Int
        get() = AttachTypes.PHOTO.ordinal
}

class Audio(val name: String = "", val artist: String = "") {}

class AudioAttachment(val audio: Audio) : Attachment() {
    override val a_type: Int
        get() = AttachTypes.AUDIO.ordinal
}

class Video(val lengthSecs: Int = 0) {}

class VideoAttachment(val video: Video) : Attachment() {
    override val a_type: Int
        get() = AttachTypes.VIDEO.ordinal
}

class Doc(val author: String = "") {}

class DocAttachment(val doc: Doc) : Attachment() {
    override val a_type: Int
        get() = AttachTypes.DOC.ordinal
}

class Good(val name: String = "", val count: Int = 0) {}

class GoodAttachment(val good: Good) : Attachment() {
    override val a_type: Int
        get() = AttachTypes.GOOD.ordinal
}

