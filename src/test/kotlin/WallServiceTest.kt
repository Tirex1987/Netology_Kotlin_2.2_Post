import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import post.Post
import post.WallService

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val post = Post(ownerId = 12, text = "Text", date = 123456, friendsOnly = false, markedAsAds = false)

        val result = service.add(post)

        assertEquals(1, result.id)
    }

    @Test
    fun update_isUpdatedPost() {
        val service = WallService()
        service.add(Post(ownerId = 12, text = "Text 1", date = 111, friendsOnly = false, markedAsAds = false))
        service.add(Post(ownerId = 20, text = "Text 2", date = 222, friendsOnly = true, markedAsAds = false))
        service.add(Post(ownerId = 30, text = "Text 3", date = 333, friendsOnly = false, markedAsAds = true))
        val update = Post(
            id = 2, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = Any(), copyright = Any(), likes = Any(),
            reposts = Object(), views = Any(), postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = true, isFavorite = false,
            donut = Any(), postponedId = 0
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun update_noUpdatedPost() {
        val service = WallService()
        service.add(Post(ownerId = 12, text = "Text 1", date = 111, friendsOnly = false, markedAsAds = false))
        service.add(Post(ownerId = 20, text = "Text 2", date = 222, friendsOnly = true, markedAsAds = false))
        service.add(Post(ownerId = 30, text = "Text 3", date = 333, friendsOnly = false, markedAsAds = true))
        val update = Post(
            id = 4, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = Object(), copyright = Object(), likes = Object(),
            reposts = Object(), views = Object(), postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = true, isFavorite = false,
            donut = Object(), postponedId = 0
        )

        val result = service.update(update)

        assertTrue(result)
    }
}