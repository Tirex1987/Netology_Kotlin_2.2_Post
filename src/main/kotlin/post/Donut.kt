package post

data class Donut(
    val isDonut: Boolean,               //запись доступна только платным подписчикам VK Donut
    val paidDuration: Int,              //время, в течение которого запись будет доступна только платным подписчикам VK Donut
    val placeholder: String,            //заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи
    val canPublishFreeCopy: Boolean,    //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut
    val editMode: String                //информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
                                            //all — всю информацию о VK Donut
                                            //duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.
)