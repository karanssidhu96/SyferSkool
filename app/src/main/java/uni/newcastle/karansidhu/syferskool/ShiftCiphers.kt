package uni.newcastle.karansidhu.syferskool

import uni.newcastle.karansidhu.syferskool.Modulo

/**
 * Created by Karan Sidhu on 04/05/2018.
 */

class ShiftCiphers : Cipher()
{
    fun shift(input : String, shiftValue : Int) : String {
        var output = ""
        var temp = '0'
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