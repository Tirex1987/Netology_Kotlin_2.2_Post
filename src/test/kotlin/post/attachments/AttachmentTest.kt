package post.attachments

import org.junit.Assert.assertEquals
import org.junit.Test

class AttachmentTest {

    @Test
    fun attachment_photo_get() {
        val photoAttachment: Attachment =
            PhotoAttachment(photo = Photo(2, 3, 4, 5, "Photo", 222, emptyArray(), 200, 200))

        val result = photoAttachment.type

        assertEquals("photo", result)
    }

    @Test
    fun attachment_audio_get() {
        val audioAttachment: Attachment = AudioAttachment(
            audio = Audio(
                3, 3, "Lora", "Tree", 150, "http/", 6,
                5, 5, 333, false, true
            )
        )

        val result = audioAttachment.type

        assertEquals("audio", result)
    }

    @Test
    fun attachment_video_get() {
        val videoAttachment: Attachment = VideoAttachment(
            video = Video(
                4, 4, "World", "Ho-ho-ho", 600, " ", " ",
                " ", " ", " ", " ", " ", " ",
                " ", " ", 555, 0, 10, 11, "Co",
                "men", false, true, false, "Key", false
            )
        )

        val result = videoAttachment.type

        assertEquals("video", result)
    }

    @Test
    fun attachment_link_get() {
        val linkAttachment: Attachment = LinkAttachment(
            link = Link(
                "http/", "apple", "Cap", "Bla-bla", null, null,
                null, "page", "url"
            )
        )

        val result = linkAttachment.type

        assertEquals("link", result)
    }

    @Test
    fun attachment_doc_get() {
        val docAttachment: Attachment = DocAttachment(
            doc = Doc(
                7, 7, "Green", 56, "ext", "url", 777, 0, null
            )
        )

        val result = docAttachment.type

        assertEquals("doc", result)
    }
}