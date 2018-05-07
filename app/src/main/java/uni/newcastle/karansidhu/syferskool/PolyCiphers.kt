package uni.newcastle.karansidhu.syferskool

/**
 * Created by Karan Sidhu on 07/05/2018.
 */
class PolyCiphers : Cipher()
{
    fun viegenere(input : String, key : String, encrypt : Boolean) : String
    {
        var cipherText = ""
        var j = 0

        for (i in 0 until input.length)
        {
            val letter = input[i]
            var temp = 0

            when (encrypt)
            {
                true -> temp = alphabet.indexOf(letter) + alphabet.indexOf(key[j])
                false -> temp = alphabet.indexOf(letter) - alphabet.indexOf(key[j])
            }

            temp = Modulo(temp, alphabetLength)
            cipherText += alphabet[temp]

            j = Modulo(++j, key.length)
        }
        return cipherText
    }
}