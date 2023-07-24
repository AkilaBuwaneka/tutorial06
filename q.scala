package tutorial06

import sun.security.util.Length

object q {
  def main(args: Array[String]) {
    val x="THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
    println(encryption(x, 23));
    println(decryption(encryption(x, 23),23));
  }
  
  def encryption(str: String,key: Int): String = {
    val len=str.length();
    var new_arr= new Array[Char](len);
    var count=0;
    for(c <- str) {
      val c_to_int = c.toInt;
      if(65<=c_to_int && c_to_int<=90) {
        var r_char = c_to_int+key;
        if(r_char>90) {
          var f_char=65+(r_char-91);
          new_arr(count)=f_char.toChar;
          count+=1;
        }
        else {
          new_arr(count)=r_char.toChar;
          count+=1
        }
      }
      else {
        new_arr(count)=c_to_int.toChar;
        count+=1;
      }
    }
    return new_arr.mkString;
  }
  def decryption(str: String,key: Int): String = {
    return encryption(str, 26-key);
  }
}
