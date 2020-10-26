import ru.netology.domain.Post

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

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