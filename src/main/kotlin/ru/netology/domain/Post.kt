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
    var attachmentId: Int = 0

    private var attachments = emptyArray<Attachment?>()

    fun addAttachment(a: Attachment?): Attachment? {
        if (a != null)
//            a.id = attachmentId++
// поскольку из абстрактного Attachment поле id убрано, чтобы его установить
// в наследниках мы должны выполнять SmartCast для каждого типа
            when (a) {
                is PhotoAttachment -> a.photo.id = attachmentId
                is AudioAttachment -> a.audio.id = attachmentId
                is VideoAttachment -> a.video.id = attachmentId
                is DocAttachment -> a.doc.id = attachmentId
                is GoodAttachment -> a.good.id = attachmentId
            }
        attachments += a
        attachmentId++
        return attachments.last()
    }

    fun printAttachmentsInfo() {
        for (a in attachments) {
            if (a != null) {
                print("AttachmentType=${a.type} ")
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
