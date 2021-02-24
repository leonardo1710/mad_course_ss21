package kotlincollections

data class Product(
    val id: Int,
    val name: String,
    val price: Double
)

class Receipt(
    val id: Int,
    val seller: Worker,
    val products: List<Product>,
    val isPaid: Boolean = false
)

class Store(
    val receipts: List<Receipt>,
    val workers: List<Worker>
)

data class Worker(
    val id: Int,
    val name: String
)

fun beer() = Product(id = 2, name = "Beer, light, 0.5l", price = 7.5)
fun coffee() = Product(id = 3, name = "Ground coffee 1kg", price = 5.0)
fun bread() = Product(id = 1, name = "Gluten-free bread, 1kg", price = 5.0)

fun main(args: Array<String>) {
    val firstWorker = Worker(id = 1, name = "Filip")
    val secondWorker = Worker(id = 2, name = "Chris")

    //create a store that contains receipts and workers
    val store = Store(
        // 1
        receipts = listOf(
            Receipt(
                //2
                id = 1,
                seller = firstWorker,
                products = listOf(bread(), bread(), bread(), coffee(), beer()),
                isPaid = true
            ),

            Receipt(
                id = 2,
                seller = secondWorker,
                products = listOf(coffee(), coffee(), beer(), beer(), beer(), beer(), beer()),
                isPaid = false
            ),

            Receipt(
                id = 3,
                seller = secondWorker,
                products = listOf(beer(), beer(), bread()),
                isPaid = false
            )
        ),
        // 3
        workers = listOf(firstWorker, secondWorker)
    )

    println(store.receipts[0].seller)


    //transforming data
    val receipts = store.receipts // fetch the receipts
    val productsLists = receipts.map { it.products } // List<List<Product>>
    println(productsLists)

    val allProducts = receipts.flatMap { it.products } // List<Product>
    println(allProducts)



    val allProductsEarnings = receipts.flatMap { it.products }  //get all products
        .map { it.price }                                       //map previosly products with price
        .sumByDouble { it }                                     //sum all prices
    println(allProductsEarnings)


    // filtering by condition
    val paidReceipts = receipts.filter { it.isPaid }
    println(paidReceipts)

// grouping values by condition
    val paidUnpaid = receipts.partition { it.isPaid }
    val (paid, unpaid) = paidUnpaid
    println(paid)
    println(unpaid)

    val groupedByWorker = receipts.groupBy { it.seller } // Map<Worker, List<Receipt>>
    println(groupedByWorker)

    //Searching data
    val receiptByIndex = receipts[0] // receipt.get(0)
    val firstPaidReceipt = receipts.first { it.isPaid } // will crash if there is none
    val firstPaidReceiptOrNull = receipts.firstOrNull { it.isPaid } // either is paid, or null
    val lastByPredicate = receipts.last { !it.isPaid } // last which is not paid
}