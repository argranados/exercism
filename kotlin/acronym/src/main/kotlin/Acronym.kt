object Acronym {
    fun generate(phrase: String) : String {
        val newPhrase = phrase.replace("-", " ").replace("_", " ")
        var tokens = newPhrase.split(" ")
        println(tokens)
        var acronym = StringBuilder()

        for (token in tokens){
            if (token.trim().isNotEmpty()){
                acronym.append(token.uppercase()[0])
            }
        }
        return acronym.toString()
    }
}
