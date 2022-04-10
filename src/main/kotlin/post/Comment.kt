package post

import post.attachments.Attachment

open class Comment(
    var id: Int,
    val fromId: Int,
    val postId: Int,
    var date: Int,
    val text: String,
    val replyToUser: Int,
    val attachments: Array<Attachment>?,
    val parentsStack: Array<Int>?,
    val thread: ThreadComments?
)

data class ThreadComments(
    val count: Int,
    val items: Array<Comment>?,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
)