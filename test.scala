def phoneNumConvert(tel: String): String = {
  val result = tel.replaceAll(",","").trim
  return result
}



phoneNumConvert("965,560,484")
phoneNumConvert("974,192,814")
