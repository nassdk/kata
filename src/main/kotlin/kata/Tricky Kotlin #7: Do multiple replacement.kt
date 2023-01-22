fun main() {
    print(f("You }}need{{ >extra< time ) or money ("))
}


fun f(s:String): String {
    return s.replace("(", ")")
        .replace(")", "(")
        .replace("<", ">")
        .replace(">", "<")
        .replace("{", "}")
        .replace("}", "{")
}

