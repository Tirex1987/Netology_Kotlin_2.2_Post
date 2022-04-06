package post.attachments

data class VideoAttachment(
    override val type: String = "video",
    val video: Video
): Attachment

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val photo130: String,
    val photo320: String,
    val photo640: String,
    val photo800: String,
    val photo1280: String,
    val firstFrame130: String,
    val firstFrame320: String,
    val firstFrame640: String,
    val firstFrame800: String,
    val firstFrame1280: String,
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val comments: Int,
    val player: String,
    val platform: String,
    val canEdit: Boolean,
    val canAdd: Boolean,
    val isPrivate: Boolean,
    val accessKey: String,
    val processing: Boolean
)