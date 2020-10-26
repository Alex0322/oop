package ru.netology.domain

data class Post(
    val ownerId: Long = 0,
    val fromId: Long = 0,
    val createdBy: Long = 0,
    val date: Long = 0,
    val text: String = "",
    val replyOwnerId: Long? = 0,
    val replyPostId: Long? = 0,
    val friendsOnly: Long = 0,
    val copyright: String = "",
    val signerId: Long? = 0,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Long = 0
) {
    var id: Long = 0

    private var attachments = emptyArray<Attachment>()

    fun addAttachment(a: Attachment): Attachment {
        a.id = attachments.size.toInt() + 1
        attachments += a
        return attachments.last()
    }

    //вывести инфу по всем вложениям
    fun printAttachmentsInfo() {
        for (a in attachments) {
            //общая инфа по вложению
            print("AttachmentId=${a.id} ")
            //специфичная инфа по вложению
            when (a) {
                is PhotoAttachment -> println("Photo:orientation=${a.photo.orientation}")
                is AudioAttachment -> println("Audio:artist=${a.audio.artist}")
                is VideoAttachment -> println("Video:lengthSecs=${a.video.lengthSecs}")
                is DocAttachment -> println("Doc:author=${a.doc.author}")
                is GoodAttachment -> println("Good:count=${a.good.count}")
            }
        }
    }

    val comments = Comments()
    val likes = Likes()
    val reposts = Reposts()
    val views = Views()

    fun printAll(): String {
        return "Post.id=$id\n${this.toString()}\n\n${comments.toString()}\n\n${likes.toString()}\n\n${reposts.toString()}"
    }

    fun copy(id: Long = this.id, date: Long = this.date, ownerId: Long = this.ownerId): Post {
        // в однострочном виде функцию записать не полчается, т.к. нужно и вернуть Post и установить id
        val p = Post(date = date, ownerId = ownerId)
        p.id = id
        return p
    }

    data class Comments(
        val count: Long? = 0,
        val canPost: Boolean = false,
        val groupCanPost: Boolean = false,
        val canClose: Boolean = false,
        val canOpen: Boolean = false
    )

    data class Likes(
        val count: Long? = 0,
        val userLikes: Boolean = false,
        val canLike: Boolean = false,
        val canPublish: Boolean = false
    )

    data class Reposts(
        val count: Long? = 0,
        val userReposted: Boolean = false
    )

    data class Views(
        val count: Long? = 0
    )
}
