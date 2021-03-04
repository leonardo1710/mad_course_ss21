package at.ac.fhcampus.numbermaster


data class GuessItem(
    val order: String,
    val guess : String,
    val firstSymbolSrc: Int,
    val secondSymbolSrc: Int,
    val thirdSymbolSrc: Int,
    val fourthSymbolSrc: Int)