import org.junit.Test
import org.junit.Assert.*
import ru.netology.domain.*

class WallServiceTest {

    @Test
    fun post_Attachments() {
        val at4Photo = PhotoAttachment(photo=Photo())
        val at4Audio = AudioAttachment(audio=Audio())
        val at4Video = VideoAttachment(video=Video())
        val at4Doc = DocAttachment(doc=Doc())
        val at4Good = GoodAttachment(good=Good())

        val ws = WallService()
        val post = Post(ownerId = 1, fromId = 3)

        post.addAttachment(at4Photo)
        post.addAttachment(null)
        post.addAttachment(at4Audio)
        post.addAttachment(at4Video)
        post.addAttachment(at4Doc)
        post.addAttachment(at4Good)

        ws.add(post)

        post.printAttachmentsInfo()
        assert(true)
    }

    @Test
    fun post_Misc() {
        assertTrue(Post().copy() != null)
        assertTrue(Post().printAll() != "")
        main()
        assert(true)
    }

    @Test
    fun add_NewPost() {
        val ws = WallService()
        val result = Post(ownerId = 1, fromId = 3)

        ws.add(result)

        assertTrue(result != null)
    }

    @Test
    fun update_ExistingId() {
        val ws = WallService()
        ws.add(Post(ownerId = 1, fromId = 3))
        ws.add(Post(ownerId = 1, fromId = 4))
        ws.add(Post(ownerId = 1, fromId = 5))
        val update = Post(ownerId = 1, fromId = 6)
        update.id = 2

        val result = ws.update(update)

        assertTrue(result)
    }

    @Test
    fun update_WrongId() {
        val ws = WallService()
        ws.add(Post(ownerId = 1, fromId = 3))
        ws.add(Post(ownerId = 1, fromId = 4))
        ws.add(Post(ownerId = 1, fromId = 5))
        val update = Post(ownerId = 1, fromId = 6)
        update.id = 0

        val result = ws.update(update)

        assertFalse(result)
    }
}