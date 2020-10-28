import ru.netology.domain.*

fun main(){
    val ws = WallService()
    ws.add(Post(ownerId = 1, fromId = 3))
    ws.add(Post(ownerId = 1, fromId = 4))
    ws.add(Post(ownerId = 1, fromId = 5))
    val update = Post(ownerId = 1, fromId = 6)
    update.id = 2

    val result = ws.update(update)
}

class WallService {
    private val posts: ArrayList<Post> = arrayListOf()

    fun add(post: Post): Post {
        // id поста не может быть иницилизировано в конструкторе Post, т.к. там мы не ещё знаем о массиве
        // оно формируется в WallService только в этот момент и должно быть var в классе
        // если бы ВСЕ Post создавались через WallService - тогда id можно было сделать val
        post.id = posts.size.toLong() + 1
        posts.add(post)
        return post
    }

    fun update(post: Post): Boolean {
        // поиск поста по id сводится к выборке из массива по индексу
        val i = post.id.toInt() - 1
        if (i < 0 || i >= posts.size)
            return false
        val arrayPost: Post = posts[i]

        // восстанавливаем в элементе массива пост-параметр с неизменными полями старого поста
        posts[i] = post.copy(id = i.toLong() + 1, date = arrayPost.date, ownerId = arrayPost.ownerId)

        return true
    }

}
