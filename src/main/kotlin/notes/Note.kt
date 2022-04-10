package notes

data class Note(
    var id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val viewUrl: String,
    var comments: Int = 0,
    var readComments: Int = 0
)