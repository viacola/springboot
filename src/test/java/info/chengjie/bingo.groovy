package info.chengjie


def find(list, tester) {
    for (item in list)
        if (tester(item)) return item
}

println ( find([1, 2] ) {it > 1} )




import groovy.transform.*
import groovyx.gpars.GParsPool

@TailRecursive
long totalPopulation(list, total = 0 ) {
    if (list.size() == 0)
        total
    else
        totalPopulation(list.tail(), total + list.first().population)
}

@Canonical class City {int population}
def cities = (10..1000).collect {new City(it)}
println totalPopulation(cities)



