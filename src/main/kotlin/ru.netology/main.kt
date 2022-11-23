package ru.netology

fun main() {
    val postLike = Likes(count = 0)
    val post = Post(1, 1, 1, 1, "Hello", true, false, false, false, postLike)
    val postCorrect = Post(1, 1, 1, 1, "Hi", true, false,false, false, postLike)
    WallService.add(post)
    WallService.update(postCorrect)
}

data class Post(
    val id: Int,
    val ownerID: Int,
    val fromID: Int,
    val date: Int,
    val text: String,
    val canDelete: Boolean,
    val markedAsAds: Boolean,
    val isPinned: Boolean,
    val isFavorite: Boolean,
    val likes: Likes
)

data class Likes(
    val count: Int,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

object WallService {
    private var posts = emptyArray<Post>()
    private val newID = posts.size + 1
    fun add(post: Post): Post {
        val post1 = post.copy(id = newID)
        posts += post1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, originalPost) in posts.withIndex()) {
            if (post.id == originalPost.id) {
                val newPost = post.copy(id = originalPost.id, date = originalPost.date, ownerID = originalPost.ownerID)
                posts[index] = newPost
                return true
            }
        }
        return false
    }
}


