package uni.newcastle.karansidhu.syferskool

import uni.newcastle.karansidhu.syferskool.Modulo

/**
 * Created by Karan Sidhu on 04/05/2018.
 */

val alphabet = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')

val alphabetLength = 26

class ShiftCiphers()
{
    fun shift(input : String, shiftValue : Int) : String {
        var output = ""
        var temp : Char = '0'
        for (c in input)
        {
            for (i in 0 until alphabetLength)
            {
                if (c == alphabet[i])
                {
                    temp = alphabet[Modulo(i + shiftValue, alphabetLength)]
                }
            }
            output += temp
        }
        return output
    }
}