import ru.netology.domain.Post

fun main(){
    // nullable значения есть, выводятся, как null, учтено в тестах, вывод стандартным образом
    // так понял задачу, что возможность нулевых значений нигде не учитывается
    println(WallService().add(Post(replyOwnerId = null)).printAll())
}

class WallService {
    // id поста предоставляет WallService, равным индексу поста в массиве + 1
    // при условии, что мы можем только добавлять и изменять элементы все id будут уникальны
    // это корректное решение
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

        // написал свою функцию copy в классе Post
        // от var-переменных date/ownerId удалось избавиться,
        // от var id - нет, в силу реализованной технологии инициализации id после создания

        // это всё из-за завязки id на размер массива, пардон, возможно лучше
        // было прикрутить генератор id внутри класса через глобальный счетчик

        // зато - сколько пользы от исследований этих val/var зависимостей))
        // предлагаю разрешить id быть var)
        // но только в учебной модели!

        return true
    }

}
