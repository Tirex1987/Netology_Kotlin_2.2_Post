package post

data class ReportComment(
    val comment: Comment,
    val reason: Int
) : Comment(
    comment.id,
    comment.fromId,
    comment.postId,
    comment.date,
    comment.text,
    comment.replyToUser,
    comment.attachments,
    comment.parentsStack,
    comment.thread
)