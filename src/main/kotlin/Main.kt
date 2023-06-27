fun main(args: Array<String>) {
    val locations = readLocationInfo()
    var currentLocation = 64

    while (true) {
        val location = locations[currentLocation] ?: Location(0, "Sorry, something went wrong, so we're going to crash")

        println(location.description)

        if (location.locationId == 0) {
            break
        }

        print("Available exits are: ")
        location.exits.keys.forEach {
            print("$it, ")
        }

        val direction = readlnOrNull()?.uppercase() ?: "Z"
        if (location.exits.containsKey(direction)) {
            currentLocation = location.exits[direction]!!
        } else {
            println("You cannot go in that direction")
        }
    }
}