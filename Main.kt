var money = 550
var volOfWater = 400
var volOfMilk = 540
var massBeans = 120
var disposableCups = 9
fun main() {
    val espressoCost = 4
    val espressoWater = 250
    val espressoBeans = 16
    val espressoMilk = 0
    val latteWater = 350
    val latteMilk = 75
    val latteBeans = 20
    val latteCost = 7
    val capWater = 200
    val capMilk = 100
    val capBeans = 12
    val capCost = 6
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        val action = readln()
        println()
        when (action) {
            "remaining" -> {
                printCoffeeData(money,volOfWater,volOfMilk,massBeans,disposableCups)
            }
            "buy"-> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                val cupType = readln()
                when (cupType) {
                    "1" -> {
                        check(espressoWater,espressoMilk, espressoBeans,espressoCost)
                    }
                    "2" -> {
                        check(latteWater,latteMilk, latteBeans,latteCost)
                    }
                    "3" -> {
                        check(capWater,capMilk, capBeans,capCost)
                    }
                    "back" -> {
                        continue
                    }
                }
            }
            "fill" -> {
                print("Write how many ml of water do you want to add: ")
                volOfWater += readln().toInt()
                print("Write how many ml of milk do you want to add: ")
                volOfMilk += readln().toInt()
                print("Write how many grams of coffee beans do you want to add: ")
                massBeans += readln().toInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                disposableCups += readln().toInt()
                println()
            }
            "take" -> {
                println("I gave you $$money")
                money = 0
            }
            "exit" -> {
                break
            }
        }
    }
}
fun printCoffeeData(money: Int, volOfWater: Int, volOfMilk: Int, massBeans: Int, disposableCups: Int) {
    println("""
                The coffee machine has:
                $volOfWater ml of water
                $volOfMilk ml of milk
                $massBeans g of coffee beans
                $disposableCups disposable cups
                $$money of money
                
        """.trimIndent())
}
fun check(water: Int, milk: Int, massbeans: Int,cost: Int) {
    if (volOfWater < water) {
        println("Sorry, not enough water!\n")
    } else if (volOfMilk < milk) {
        println("Sorry, not enough milk!\n")
    } else if (massBeans < massbeans) {
        println("Sorry, not enough coffee beans!\n")
    } else {
        println("I have enough resources, making you a coffee!\n")
        money += cost
        volOfWater -= water
        massBeans -= massbeans
        volOfMilk -= milk
        --disposableCups
    }
}