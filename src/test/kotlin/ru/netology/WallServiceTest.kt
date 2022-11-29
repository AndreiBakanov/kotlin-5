package ru.netology

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addIdNoZero() {
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1
        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)
        assertNotEquals(0, post.id)

    }

    @Test
    fun updateTrue() {
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1

        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)

        val postArray1 = emptyArray<Reposts>()
        val postAttachment1 = emptyArray<Attachment>()
        val postRepost1 = Reposts(0, false)
        val postComment1 = Comments(0, true, true, true, false)
        val postGeo1 = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike1 = Likes(0)

        val id1 = 1
        val ownerID1 = 1
        val fromID1 = 1
        val createdBy1 = 1
        val date1 = 1
        val text1 = "How are you?"
        val replyOwnerID1 = 1
        val friendsOnly1 = false
        val copyright1 = "wiki"
        val views1 = 0
        val postType1 = "post"
        val postSource1 = "info"
        val signerID1 = 1
        val canPin1 = true
        val canDelete1 = true
        val canEdit1 = true
        val isPinned1 = false
        val markedAsAds1 = false
        val isFavorite1 = false
        val postponedID1 = 1
        val post1 = Post(
            id1,
            ownerID1,
            fromID1,
            createdBy1,
            date1,
            text1,
            replyOwnerID1,
            friendsOnly1,
            postLike1,
            postComment1,
            copyright1,
            postRepost1,
            views1,
            postType1,
            postSource1,
            postGeo1,
            signerID1,
            postArray1,
            canPin1,
            canDelete1,
            canEdit1,
            isPinned1,
            markedAsAds1,
            isFavorite1,
            postponedID1,
            postAttachment1
        )
        val result = WallService.update(post1)
        assertEquals(true, result)
    }

    @Test
    fun updateFalse() {
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1

        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)

        val postArray1 = emptyArray<Reposts>()
        val postAttachment1 = emptyArray<Attachment>()
        val postRepost1 = Reposts(0, false)
        val postComment1 = Comments(0, true, true, true, false)
        val postGeo1 = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike1 = Likes(0)

        val id1 = 2
        val ownerID1 = 1
        val fromID1 = 1
        val createdBy1 = 1
        val date1 = 1
        val text1 = "How are you?"
        val replyOwnerID1 = 1
        val friendsOnly1 = false
        val copyright1 = "wiki"
        val views1 = 0
        val postType1 = "post"
        val postSource1 = "info"
        val signerID1 = 1
        val canPin1 = true
        val canDelete1 = true
        val canEdit1 = true
        val isPinned1 = false
        val markedAsAds1 = false
        val isFavorite1 = false
        val postponedID1 = 1
        val post1 = Post(
            id1,
            ownerID1,
            fromID1,
            createdBy1,
            date1,
            text1,
            replyOwnerID1,
            friendsOnly1,
            postLike1,
            postComment1,
            copyright1,
            postRepost1,
            views1,
            postType1,
            postSource1,
            postGeo1,
            signerID1,
            postArray1,
            canPin1,
            canDelete1,
            canEdit1,
            isPinned1,
            markedAsAds1,
            isFavorite1,
            postponedID1,
            postAttachment1
        )
        val result = WallService.update(post1)
        assertEquals(false, result)
    }

    @Test
    fun commentShouldBeAdded() {
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1
        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)
        val idCom = 1
        val fromIDCom = 1
        val dateCom = 1
        val textCom = "Hi"
        val replyToUserCom = 1
        val replyToCommentCom = 1

        val comment = Comment(
            idCom,
            fromIDCom,
            dateCom,
            textCom,
            null,
            replyToUserCom,
            replyToCommentCom,
            null,
            null,
            null
        )
        assertEquals(comment, WallService.createComment(id, comment))

    }
    @Test(expected = PostNotFoundException::class)
    fun shouldThrowPostNotFoundException() {
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1
        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)
        val idCom = 1
        val fromIDCom = 1
        val dateCom = 1
        val textCom = "Hi"
        val replyToUserCom = 1
        val replyToCommentCom = 1

        val comment = Comment(
            idCom,
            fromIDCom,
            dateCom,
            textCom,
            null,
            replyToUserCom,
            replyToCommentCom,
            null,
            null,
            null
        )
        WallService.createComment(id + 1, comment)
    }

    @Test
    fun reportShouldBeAdded() {
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1
        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)
        val idCom = 1
        val fromIDCom = 1
        val dateCom = 1
        val textCom = "Hi"
        val replyToUserCom = 1
        val replyToCommentCom = 1

        val comment = Comment(
            idCom,
            fromIDCom,
            dateCom,
            textCom,
            null,
            replyToUserCom,
            replyToCommentCom,
            null,
            null,
            null
        )
        WallService.createComment(id, comment)

        val ownerIDRep = 1
        val commentIDRep = 1
        val reasonRep = 1
        val report = Reports(ownerIDRep, commentIDRep, reasonRep)
        assertEquals(1, WallService.createReport(report))

    }

    @Test(expected = IdNotFoundException::class)
    fun shouldThrowIdNotFoundException() {
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1
        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)
        val idCom = 1
        val fromIDCom = 1
        val dateCom = 1
        val textCom = "Hi"
        val replyToUserCom = 1
        val replyToCommentCom = 1

        val comment = Comment(
            idCom,
            fromIDCom,
            dateCom,
            textCom,
            null,
            replyToUserCom,
            replyToCommentCom,
            null,
            null,
            null
        )
        WallService.createComment(id, comment)

        val ownerIDRep = 1
        val commentIDRep = 2
        val reasonRep = 1
        val report = Reports(ownerIDRep, commentIDRep, reasonRep)
        WallService.createReport(report)
    }

    @Test(expected = CorrectReasonNotFoundException::class)
    fun CorrectReasonNotFoundException() {
        val postArray = emptyArray<Reposts>()
        val postAttachment = emptyArray<Attachment>()
        val postRepost = Reposts(0, false)
        val postComment = Comments(0, true, true, true, false)
        val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
        val postLike = Likes(0)

        val id = 1
        val ownerID = 1
        val fromID = 1
        val createdBy = 1
        val date = 1
        val text = "How are you?"
        val replyOwnerID = 1
        val friendsOnly = false
        val copyright = "wiki"
        val views = 0
        val postType = "post"
        val postSource = "info"
        val signerID = 1
        val canPin = true
        val canDelete = true
        val canEdit = true
        val isPinned = false
        val markedAsAds = false
        val isFavorite = false
        val postponedID = 1
        val post = Post(
            id,
            ownerID,
            fromID, createdBy,
            date,
            text,
            replyOwnerID,
            friendsOnly,
            postLike,
            postComment,
            copyright,
            postRepost,
            views,
            postType,
            postSource,
            postGeo,
            signerID,
            postArray,
            canPin,
            canDelete,
            canEdit,
            isPinned,
            markedAsAds,
            isFavorite,
            postponedID,
            postAttachment
        )
        WallService.add(post)
        val idCom = 1
        val fromIDCom = 1
        val dateCom = 1
        val textCom = "Hi"
        val replyToUserCom = 1
        val replyToCommentCom = 1

        val comment = Comment(
            idCom,
            fromIDCom,
            dateCom,
            textCom,
            null,
            replyToUserCom,
            replyToCommentCom,
            null,
            null,
            null
        )
        WallService.createComment(id, comment)

        val ownerIDRep = 1
        val commentIDRep = 1
        val reasonRep = 9
        val report = Reports(ownerIDRep, commentIDRep, reasonRep)
        WallService.createReport(report)
    }
}

