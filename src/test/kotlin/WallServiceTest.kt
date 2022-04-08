import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import post.*

class WallServiceTest {

    @Test
    fun add() {
        WallService.clear()
        val post = Post(
            id = 0, ownerId = 12, fromId = 12,
            createdBy = 0, date = 123456, "Text", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = emptyArray(), copyright = Any(), likes = Any(),
            reposts = Object(), views = Any(), postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = false, isFavorite = false,
            donut = Any(), postponedId = 0, attachments = emptyArray()
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
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 30, fromId = 30,
                createdBy = 0, date = 333, "Text 3", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = true, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        val update = Post(
            id = 2, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = emptyArray(), copyright = Any(), likes = Any(),
            reposts = Object(), views = Any(), postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = true, isFavorite = false,
            donut = Any(), postponedId = 0, attachments = emptyArray()
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
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 30, fromId = 30,
                createdBy = 0, date = 333, "Text 3", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = true, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        val update = Post(
            id = 4, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = emptyArray(), copyright = Object(), likes = Object(),
            reposts = Object(), views = Object(), postType = "post",
            signerId = 0, canPin = true, canDelete = true, canEdit = true,
            isPinned = false, markedAsAds = true, isFavorite = false,
            donut = Object(), postponedId = 0, attachments = emptyArray()
        )

        val result = WallService.update(update)

        assertTrue(!result)
    }

    @Test
    fun createComment_addCommentGood() {
        WallService.clear()
        WallService.add(
            Post(
                id = 0, ownerId = 12, fromId = 12,
                createdBy = 0, date = 111, "Text 1", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        val comment = Comment(
            id = 1, fromId = 50, postId = 1, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        val post = WallService.createComment(comment)
        val result = if (post.comments.isNotEmpty()) post.comments[0] else null

        assertEquals(comment, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_shouldThrow() {
        WallService.clear()
        WallService.add(
            Post(
                id = 0, ownerId = 12, fromId = 12,
                createdBy = 0, date = 111, "Text 1", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        val comment = Comment(
            id = 1, fromId = 50, postId = 3, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        WallService.createComment(comment)
    }

    @Test
    fun createReportComment_addReasonGood() {
        WallService.clear()
        WallService.add(
            Post(
                id = 0, ownerId = 12, fromId = 12,
                createdBy = 0, date = 111, "Text 1", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        val comment = Comment(
            id = 1, fromId = 50, postId = 1, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        WallService.createReportComment(comment, reason = 0)
        val reasons = WallService.getReasons()
        val result = if (reasons.isNotEmpty()) reasons[0] else null

        assertEquals(ReportComment(comment, 0), result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createReportComment_ThrowPostNotFound() {
        WallService.clear()
        WallService.add(
            Post(
                id = 0, ownerId = 12, fromId = 12,
                createdBy = 0, date = 111, "Text 1", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        val comment = Comment(
            id = 1, fromId = 50, postId = 3, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        WallService.createReportComment(comment, 0)
    }

    @Test(expected = ReasonOutOfRangeException::class)
    fun createReportComment_ThrowReasonOutOfRange() {
        WallService.clear()
        WallService.add(
            Post(
                id = 0, ownerId = 12, fromId = 12,
                createdBy = 0, date = 111, "Text 1", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = false,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        WallService.add(
            Post(
                id = 0, ownerId = 20, fromId = 20,
                createdBy = 0, date = 222, "Text 2", replyOwnerId = 0,
                replyPostId = 0, friendsOnly = true,
                comments = emptyArray(), copyright = Any(), likes = Any(),
                reposts = Object(), views = Any(), postType = "post",
                signerId = 0, canPin = true, canDelete = true, canEdit = true,
                isPinned = false, markedAsAds = false, isFavorite = false,
                donut = Any(), postponedId = 0, attachments = emptyArray()
            )
        )
        val comment = Comment(
            id = 1, fromId = 50, postId = 3, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        WallService.createReportComment(comment, 10)
    }
}