package uni.newcastle.karansidhu.syferskool

/**
 * Created by Karan Sidhu on 04/05/2018.
 */

fun Modulo(val1 : Int, val2 : Int) : Int
{
    var result = (val1).rem(val2)
    if (result < 0) result += val2
    return result
}