package post

data class Post(
    val id: Int,                //Идентификатор записи
    val ownerId: Int,           //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int,            //Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: Int,         //Идентификатор администратора, который опубликовал запись
    val date: Int,              //Время публикации записи в формате
    var text: String,           //Текст записи
    val replyOwnerId: Int,      //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int,       //Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean,   // true, если запись была создана с опцией «Только для друзей»
    val comments: Any,       //Информация о комментариях к записи
    val copyright: Any,      //Источник материала
    val likes: Any,          //Информация о лайках к записи
    val reposts: Any,        //Информация о репостах записи («Рассказать друзьям»)
    val views: Any,          //Информация о просмотрах записи
    val postType: String,       //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest
    val signerId: Int,          //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    var canPin: Boolean,        //Информация о том, может ли текущий пользователь закрепить запись
    var canDelete: Boolean,     //Информация о том, может ли текущий пользователь удалить запись
    var canEdit: Boolean,       //Информация о том, может ли текущий пользователь редактировать запись
    var isPinned: Boolean,      //Информация о том, что запись закреплена
    var markedAsAds: Boolean,   //Информация о том, содержит ли запись отметку «реклама»
    var isFavorite: Boolean,    //true, если объект добавлен в закладки у текущего пользователя
    var donut: Any,          //Информация о записи VK Donut
    var postponedId: Int        //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере
)