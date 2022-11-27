package ru.netology

fun main() {
    val postArray = emptyArray<Reposts>()
    val postAttachment = emptyArray<Attachment>()
    val postRepost = Reposts(0, false)
    val postComment = Comments(0, true, true, true, false)
    val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
    val postLike = Likes(0)
    val post = Post(
        1,
        1,
        1,
        1,
        1,
        "Hello",
        1,
        false,
        postLike,
        null,
        "wiki",
        postRepost,
        0,
        "post",
        "info",
        postGeo,
        1,
        postArray,
        true,
        true,
        true,
        false,
        false,
        false,
        1,
        postAttachment
    )
    val postCorrect = Post(
        1,
        1,
        1,
        1,
        1,
        "Hi",
        1,
        false,
        postLike,
        postComment,
        "wiki",
        postRepost,
        0,
        "post",
        "info",
        postGeo,
        1,
        postArray,
        true,
        true,
        true,
        false,
        false,
        false,
        1,
        postAttachment
    )
    WallService.add(post)
    WallService.update(postCorrect)
}

data class Post(
    val id: Int,
    val ownerID: Int,
    val fromID: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerID: Int,
    val friendsOnly: Boolean,
    val likes: Likes,
    val comments: Comments?,
    val copyright: String,
    val reposts: Reposts?,
    val views: Int,
    val postType: String,
    val postSource: String,
    val geo: Geo,
    val signerID: Int,
    val copyHistory: Array<Reposts>,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedID: Int,
    val attachments: Array<Attachment>
)

data class Geo(
    val type: String,
    val coordinates: String,
    val place: String?
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
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

interface Attachment {
    val type: String
}

data class AudioAttachment(
    override val type: String = "audio",
    val data: Audio
) : Attachment

data class VideoAttachment(
    override val type: String = "video",
    val data: Video
) : Attachment

data class PhotoAttachment(
    override val type: String = "photo",
    val data: Photo
) : Attachment

data class GraffitiAttachment(
    override val type: String = "graffiti",
    val data: Graffiti
) : Attachment

data class AppAttachment(
    override val type: String = "app",
    val data: App
) : Attachment

data class Audio(
    val id: Int,
    val albumID: Int,
    val ownerID: Int,
    val userID: Int
)

data class Graffiti(
    val id: Int,
    val ownerID: Int,
    val photo130: String,
    val photo604: String,
)

data class App(
    val id: Int,
    val name: String,
    val photo130: String,
    val photo604: String,
)

data class Video(
    val id: Int,
    val albumID: Int,
    val ownerID: Int,
    val userID: Int
)

data class Photo(
    val id: Int,
    val albumID: Int,
    val ownerID: Int,
    val userID: Int,
    val text: String,
    val date: Int,
    val sizes: Array<photoSizes>?,
    val width: Int,
    val height: Int
)

data class photoSizes(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)


