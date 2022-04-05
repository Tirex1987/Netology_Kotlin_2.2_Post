package post

data class Geo(
    val type: String,           //тип места
    val coordinates: String,    //координаты места
    val place: Place?           //описание места (если оно добавлено)
)

data class Place(
    val id: Int,        //Идентификатор места.
    val title: String,  //Название места.
    val latitude: Int,  //Географическая широта, заданная в градусах (от -90 до 90)
    val longitude: Int, //Географическая широта, заданная в градусах (от -90 до 90)
    val created: Int,   //Дата создания места в Unixtime
    val icon: String,   //Иконка места, URL изображения
    val checkins: Int,  //Число отметок в этом месте
    val update: Int,    //Дата обновления места в Unixtime
    val type: Int,      //Тип места
    val country: Int,   //Идентификатор страны
    val city: Int,      //Идентификатор города
    val addresse: Int   //Адрес места
)