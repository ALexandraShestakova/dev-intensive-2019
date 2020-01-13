package devintensive.skillbranch.ru.dev_intensive.extensions

import devintensive.skillbranch.ru.dev_intensive.models.User
import devintensive.skillbranch.ru.dev_intensive.models.UserView
import devintensive.skillbranch.ru.dev_intensive.units.Units
import java.util.*

fun User.toUserView() : UserView{
    val nickName = Units.transliteration("$firstName $lastName")
    val initials = Units.toInitials(firstName, lastName)
    val status =if(lastVisit == null) "Ещё ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDate()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status
    )
}


