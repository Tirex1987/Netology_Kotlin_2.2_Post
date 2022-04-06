package post.attachments

interface Attachment{
    val type: String
        get() = when(this){
            is PhotoAttachment -> "photo"
            is VideoAttachment -> "video"
            is AudioAttachment -> "audio"
            is DocAttachment -> "doc"
            is LinkAttachment -> "link"
            else -> TODO()
        }
}
