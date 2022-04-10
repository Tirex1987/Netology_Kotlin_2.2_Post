package notes

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import post.Comment
import kotlin.time.measureTimedValue

class NoteServiceTest {

    @Test
    fun add() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")

        val result = NoteService.add(note)

        assertEquals(note, result)
    }

    @Test
    fun createComment_good() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        NoteService.add(note)
        val comment = Comment(
            id = 1, fromId = 50, postId = 1, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        val result = NoteService.createComment(comment)

        assertEquals(comment, result)
    }

    @Test(expected = NotFindNoteException::class)
    fun createComment_exception() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        NoteService.add(note)
        val comment = Comment(
            id = 0, fromId = 50, postId = 0, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        NoteService.createComment(comment)
    }

    @Test
    fun delete() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        NoteService.add(note)

        val result = NoteService.delete(note)

        assertTrue(result)
    }

    @Test
    fun deleteComment_good() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        NoteService.add(note)
        val comment = Comment(
            id = 0, fromId = 50, postId = 1, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )
        NoteService.createComment(comment)

        val result = NoteService.deleteComment(comment)

        assertTrue(result)
    }

    @Test(expected = NotFindNoteException::class)
    fun deleteComment_exception() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        NoteService.add(note)
        val comment = Comment(
            id = 0, fromId = 50, postId = 1, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )
        NoteService.createComment(comment)
        val deletedComment = Comment(
            id = 0, fromId = 70, postId = 2, date = 555, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        NoteService.deleteComment(deletedComment)
    }

    @Test
    fun edit() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        NoteService.add(note)
        val editedNote = NoteService.add(note)!!.copy(text = "Bla-bla")

        val result = NoteService.edit(editedNote)

        assertTrue(result)
    }

    @Test
    fun editComment() {
        NoteService.clear()
        val note = Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        NoteService.add(note)
        val comment = Comment(
            id = 0, fromId = 50, postId = 1, date = 333, text = "Text", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )
        val createdComment = NoteService.createComment(comment)
        val editedComment = Comment(
            createdComment.id, fromId = 50, postId = 1, date = 555, text = "Bla-bla", replyToUser = 0,
            attachments = null, parentsStack = null, thread = null
        )

        val result = NoteService.editComment(editedComment)

        assertTrue(result)
    }

    @Test
    fun getById() {
        NoteService.clear()
        val addedNote = NoteService.add(
            Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        )

        val result = NoteService.getById(1)

        assertEquals(addedNote, result)
    }

    @Test
    fun get() {
        NoteService.clear()
        val note1 = NoteService.add(
            Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        )
        NoteService.add(
            Note(id = 0, ownerId = 78, title = "Title", text = "Text", date = 222, viewUrl = "http")
        )
        val note3 = NoteService.add(
            Note(id = 0, ownerId = 5, title = "Title", text = "Text", date = 333, viewUrl = "http")
        )
        val list = ArrayList<Note?>()
        list.add(note1)
        list.add(note3)

        val result = NoteService.get(5)

        assertEquals(list, result)
    }

    @Test
    fun getComments() {
        NoteService.clear()
        NoteService.add(
            Note(id = 1, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        )
        NoteService.add(
            Note(id = 2, ownerId = 8, title = "Title22", text = "Text22", date = 666, viewUrl = "http")
        )
        val comment1 = NoteService.createComment(
            Comment(
                id = 0, fromId = 50, postId = 1, date = 333, text = "Text1",
                replyToUser = 0, attachments = null, parentsStack = null, thread = null
            )
        )
        NoteService.createComment(
            Comment(
                id = 0, fromId = 50, postId = 2, date = 444, text = "Text2",
                replyToUser = 0, attachments = null, parentsStack = null, thread = null
            )
        )
        val comment3 = NoteService.createComment(
            Comment(
                id = 0, fromId = 60, postId = 1, date = 555, text = "Text3",
                replyToUser = 0, attachments = null, parentsStack = null, thread = null
            )
        )
        val list = ArrayList<Comment>()
        list.add(comment1)
        list.add(comment3)

        val result = NoteService.getComments(1)

        assertEquals(list, result)
    }

    @Test
    fun restoreComment() {
        NoteService.clear()
        NoteService.add(
            Note(id = 1, ownerId = 5, title = "Title", text = "Text", date = 222, viewUrl = "http")
        )
        NoteService.createComment(
            Comment(
                id = 0, fromId = 50, postId = 1, date = 333, text = "Text1",
                replyToUser = 0, attachments = null, parentsStack = null, thread = null
            )
        )
        val comment = NoteService.createComment(
            Comment(
                id = 0, fromId = 55, postId = 1, date = 444, text = "Text2",
                replyToUser = 0, attachments = null, parentsStack = null, thread = null
            )
        )
        NoteService.createComment(
            Comment(
                id = 0, fromId = 60, postId = 1, date = 555, text = "Text3",
                replyToUser = 0, attachments = null, parentsStack = null, thread = null
            )
        )
        NoteService.deleteComment(comment)

        val result = NoteService.restoreComment(comment)

        assertTrue(result)
    }
}