import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import post.Post

class WallServiceTest {

    @Test
    fun add() {
        WallService.clear()
        val post = Post(
            id = 0, ownerId = 12, fromId = 12,
            createdBy = 0, date = 123456, "Text", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = null, copyright = null, likes = null,
            reposts = null, views = null, postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = false, isFavorite = false,
            donut = null, postponedId = 0,
            copyHistory = emptyArray(), geo = null, postSource = null
        )

        val result = WallService.add(post)

        assertEquals(1, result.id)
    }

    @Test
    fun update_isUpdatedPost() {
        WallService.clear()
        WallService.add(
            Post(
                id = 2, ownerId = 12, fromId = 12,
                createdBy = 0, date = 111, "Text 1", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = null, copyright = null, likes = null,
                reposts = null, views = null, postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = null, postponedId = 0,
                copyHistory = emptyArray(), geo = null, postSource = null
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = null, copyright = null, likes = null,
                reposts = null, views = null, postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = null, postponedId = 0,
                copyHistory = emptyArray(), geo = null, postSource = null
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 30, fromId = 30,
                createdBy = 0, date = 333, "Text 3", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = null, copyright = null, likes = null,
                reposts = null, views = null, postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = true, isFavorite = false,
                donut = null, postponedId = 0,
                copyHistory = emptyArray(), geo = null, postSource = null
            )
        )
        val update = Post(
            id = 2, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = null, copyright = null, likes = null,
            reposts = null, views = null, postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = true, isFavorite = false,
            donut = null, postponedId = 0,
            copyHistory = emptyArray(), geo = null, postSource = null
        )

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Test
    fun update_noUpdatedPost() {
        WallService.clear()
        WallService.add(
            Post(
                id = 2, ownerId = 12, fromId = 12,
                createdBy = 0, date = 111, "Text 1", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = null, copyright = null, likes = null,
                reposts = null, views = null, postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = null, postponedId = 0,
                copyHistory = emptyArray(), geo = null, postSource = null
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = null, copyright = null, likes = null,
                reposts = null, views = null, postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = null, postponedId = 0,
                copyHistory = emptyArray(), geo = null, postSource = null
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 30, fromId = 30,
                createdBy = 0, date = 333, "Text 3", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = null, copyright = null, likes = null,
                reposts = null, views = null, postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = true, isFavorite = false,
                donut = null, postponedId = 0,
                copyHistory = emptyArray(), geo = null, postSource = null
            )
        )
        val update = Post(
            id = 4, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = null, copyright = null, likes = null,
            reposts = null, views = null, postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = true, isFavorite = false,
            donut = null, postponedId = 0,
            copyHistory = emptyArray(), geo = null, postSource = null
        )

        val result = WallService.update(update)

        assertTrue(!result)
    }
}