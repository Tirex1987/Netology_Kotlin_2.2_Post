package post

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportComments = emptyArray<ReportComment>()
    private var lastId = 0

    fun add(post: Post): Post {
        post.id = ++lastId
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, targetPost) in posts.withIndex()) {
            if (targetPost.id == post.id) {
                posts[index] = post.copy(id = targetPost.id, date = targetPost.date)
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    fun createComment(comment: Comment): Post {
        for (post in posts) {
            if (comment.postId == post.id) {
                comments += comment
                post.comments += comment
                return post
            }
        }
        throw PostNotFoundException("Post with id = ${comment.postId} not found")
    }

    fun createReportComment(comment: Comment, reason: Int) {
        if ((reason < 0) || (reason > 8)) {
            throw ReasonOutOfRangeException("Invalid reason code: $reason")
        }
        for (post in posts) {
            if (comment.postId == post.id) {
                reportComments += ReportComment(comment, reason)
                return
            }
        }
        throw PostNotFoundException("Post with id = ${comment.postId} not found")
    }

    fun getReasons() = reportComments
}