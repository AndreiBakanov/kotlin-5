package ru.netology

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

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)
//Информация о комментариях к записи
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
data class Geo(
    val type: String,
    val coordinates: String,
    val place: String?
)