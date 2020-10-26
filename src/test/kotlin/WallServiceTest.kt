import org.junit.Test
import org.junit.Assert.*
import ru.netology.domain.*

class WallServiceTest {

    @Test
    fun post_Attachments() {
        val at4Photo = PhotoAttachment(Photo(orientation = 1))
        val at4Audio = AudioAttachment(Audio(name = "Name1", artist = "Artist1"))
        val at4Video = VideoAttachment(Video(lengthSecs = 10_000))
        val at4Doc = DocAttachment(Doc(author = "Author1"))
        val at4Good = GoodAttachment(Good(name = "Good1", count = 5))

        val ws = WallService()
        val post = Post(ownerId = 1, fromId = 3)

        post.addAttachment(at4Photo)
        post.addAttachment(at4Audio)
        post.addAttachment(at4Video)
        post.addAttachment(at4Doc)
        post.addAttachment(at4Good)

        ws.add(post)

        post.printAttachmentsInfo()
    }

    @Test
    fun post_Funcs() {
        assertTrue(Post().copy() != null)
        assertTrue(Post().printAll() != "")
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