package homework.solution

import kotlin.collections.filterIsInstance
import kotlin.collections.plus


data class Cart(
    val shop: Shop,
    val items: Map<ItemId, UInt> = emptyMap(),
    val discounts: List<Discount> = emptyList()
) {
    init {
        // The cart is not allowed to contain items that are not in the shop.
        require(shop.items.keys.containsAll(items.keys))
    }

    val effectiveDiscounts: List<Discount> by lazy {
        val bundles = discounts
            .filterIsInstance<Discount.Bundle>()
            .groupBy { it.itemId }
            .mapNotNull { (itemId, bundles) ->
                bundles.maxByOrNull { it.freeItems(items[itemId] ?: 0u) }
            }
        val fixed = discounts.filterIsInstance<Discount.Fixed>()
        val percentage = discounts.filterIsInstance<Discount.Percentage>()

        bundles + fixed + percentage
    }

    val price: Euro by lazy {
        val price = items
            .map { (itemId, amount) -> shop.items.getValue(itemId).price * amount }
            .fold(0u.euro, Euro::plus)

        effectiveDiscounts
            .fold(price) { total, price -> price.apply(this, total) }
    }
}

operator fun Cart.plus(other: Pair<ItemId, UInt>): Cart {
    val currentAmount = items[other.first] ?: 0u
    val pair = other.copy(second = other.second + currentAmount)

    return copy(items = items + pair)
}

operator fun Cart.plus(other: ItemId): Cart = this + (other to 1u)

operator fun Cart.plus(other: Discount): Cart = copy(discounts = this.discounts + other)

operator fun Cart.plus(other: List<Discount>): Cart = copy(discounts = this.discounts + other)
