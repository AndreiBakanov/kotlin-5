package ru.netology

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addIdNoZero() {
        val id: Int = 1
        val ownerID: Int = 1
        val fromID: Int = 1
        val date: Int = 1
        val text: String = "Hi"
        val canDelete: Boolean = true
        val markedAsAds: Boolean = true
        val isPinned: Boolean = true
        val isFavorite: Boolean = true
        val likes = Likes(0)
        val post = Post(
            id,
            ownerID,
            fromID,
            date,
            text,
            canDelete,
            markedAsAds,
            isPinned,
            isFavorite,
            likes
        )
        WallService.add(post)
        assertNotEquals(0, post.id)

    }

    @Test
    fun updateTrue() {
        val id: Int = 1
        val ownerID: Int = 1
        val fromID: Int = 1
        val date: Int = 1
        val text: String = "Hi"
        val canDelete: Boolean = true
        val markedAsAds: Boolean = true
        val isPinned: Boolean = true
        val isFavorite: Boolean = true
        val likes = Likes(0)
        val post = Post(
            id,
            ownerID,
            fromID,
            date,
            text,
            canDelete,
            markedAsAds,
            isPinned,
            isFavorite,
            likes
        )
        WallService.add(post)
        val id1: Int = 1
        val ownerID1: Int = 1
        val fromID1: Int = 1
        val date1: Int = 1
        val text1: String = "Hello"
        val canDelete1: Boolean = true
        val markedAsAds1: Boolean = true
        val isPinned1: Boolean = true
        val isFavorite1: Boolean = true
        val likes1 = Likes(0)
        val post1 = Post(
            id1,
            ownerID1,
            fromID1,
            date1,
            text1,
            canDelete1,
            markedAsAds1,
            isPinned1,
            isFavorite1,
            likes1
        )
        val result = WallService.update(post1)
        assertEquals(true, result)
    }
    @Test
    fun updateFalse() {
        val id: Int = 1
        val ownerID: Int = 1
        val fromID: Int = 1
        val date: Int = 1
        val text: String = "Hi"
        val canDelete: Boolean = true
        val markedAsAds: Boolean = true
        val isPinned: Boolean = true
        val isFavorite: Boolean = true
        val likes = Likes(0)
        val post = Post(
            id,
            ownerID,
            fromID,
            date,
            text,
            canDelete,
            markedAsAds,
            isPinned,
            isFavorite,
            likes
        )
        WallService.add(post)
        val id1: Int = 2
        val ownerID1: Int = 1
        val fromID1: Int = 1
        val date1: Int = 1
        val text1: String = "Hello"
        val canDelete1: Boolean = true
        val markedAsAds1: Boolean = true
        val isPinned1: Boolean = true
        val isFavorite1: Boolean = true
        val likes1 = Likes(0)
        val post1 = Post(
            id1,
            ownerID1,
            fromID1,
            date1,
            text1,
            canDelete1,
            markedAsAds1,
            isPinned1,
            isFavorite1,
            likes1
        )
        val result = WallService.update(post1)
        assertEquals(false, result)
    }
}
