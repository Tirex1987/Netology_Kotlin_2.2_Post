package post

data class Reposts(
    val count: Int,             //число пользователей, скопировавших запись
    val userReposted: Boolean   //наличие репоста от текущего пользователя
)