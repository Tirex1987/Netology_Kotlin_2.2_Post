package post

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post{
        val id = if (posts.isEmpty()){
            1
        } else {
            posts.last().id + 1
        }
        posts += post.copy(id = id)
        return posts.last()
    }

    fun update(post:Post): Boolean{
        for ((index, targetPost) in posts.withIndex()){
            if (targetPost.id == post.id){
                posts[index] = post.copy(date = targetPost.date)
                return true
            }
        }
        return false
    }

    fun clear(){
        posts = emptyArray()
    }
}