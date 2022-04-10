package notes

import post.Comment

object NoteService {
    private var notes: ManagerMessages<Note> = ManagerMessages()
    private var comments: ManagerMessages<Comment> = ManagerMessages()

    fun add(note: Note): Note? {
        note.id = notes.add(note)
        return notes.getById(note.id)
    }

    fun createComment(comment: Comment): Comment {
        val note = notes.getById(comment.postId) ?: throw NotFindNoteException("Note not found or has been deleted")
        comment.id = comments.add(comment)
        note.comments++
        return comment
    }

    fun delete(note: Note): Boolean {
        if (!notes.delete(note)) {
            return false
        }
        val commentsForDeleted = comments.getMessages()
        for (comment in commentsForDeleted) {
            if (comment.postId == note.id) {
                comments.delete(comment)
            }
        }
        return true
    }

    fun deleteComment(comment: Comment): Boolean {
        val note = notes.getById(comment.postId) ?: throw NotFindNoteException("Note not found or has been deleted")
        if (!comments.delete(comment)) {
            return false
        }
        note.comments--
        return true
    }

    fun edit(note: Note): Boolean {
        val targetNote = notes.getById(note.id) ?: return false
        return notes.edit(note.id, note.copy(date = targetNote.date))
    }

    fun editComment(comment: Comment): Boolean {
        val targetComment = comments.getById(comment.id) ?: return false
        comment.date = targetComment.date
        return comments.edit(comment.id, comment)
    }

    fun getById(id: Int): Note? {
        return notes.getById(id)
    }

    fun get(ownerId: Int): List<Note> {
        val notesForOwnerId = ArrayList<Note>()
        val notesList = notes.getMessages()
        for (note in notesList) {
            if (note.ownerId == ownerId) {
                notesForOwnerId.add(note)
            }
        }
        return notesForOwnerId
    }

    fun getComments(noteId: Int): List<Comment> {
        val commentsForNoteId = ArrayList<Comment>()
        val commentsList = comments.getMessages()
        for (comment in commentsList) {
            if (comment.postId == noteId) {
                commentsForNoteId.add(comment)
            }
        }
        return commentsForNoteId
    }

    fun restoreComment(comment: Comment): Boolean {
        return comments.restore(comment)
    }

    fun clear(){
        notes = ManagerMessages()
        comments = ManagerMessages()
    }
}