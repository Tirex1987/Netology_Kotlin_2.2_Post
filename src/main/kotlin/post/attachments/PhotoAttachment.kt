package post.attachments

data class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
): Attachment

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<SizeInfo>,
    val width: Int,
    val height: Int
){
    data class SizeInfo(
        val type: String,
        val url: String,
        val width: Int,
        val height: Int
    )
}