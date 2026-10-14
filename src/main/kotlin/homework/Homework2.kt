package homework

/**
 * # Homework 2: Modeling a Shop
 *
 * ## Requirements
 * 1) Prices
 *    - Create a class `Euro` that wraps an unsigned integer of cents (e.g., 90 = €0.90).
 *    - Implement operators so you can add, subtract, and multiply amounts.
 *
 * 2) Items
 *    - Model each item with its name and price.
 *    - Create an `ItemId` value class wrapping a [String] (e.g., ItemId("apple"))
 *      to indentify items.
 *
 * 3) Shop
 *    - Store a `Map<ItemId, Item>` in the shop.
 *
 * 4) Shopping cart
 *    - Store quantities in a `Map<ItemId, UInt>` and look up prices in the shop.
 *
 * 5) Discounts
 *    - Support three discount kinds:
 *      - Percentage (e.g., 20% off the current total)
 *      - Fixed amount off (e.g., €5.00 off)
 *      - Bundle (e.g., “Buy 3, pay 2” for a specific item)
 *        - Example: You have 7 apples in your cart and a “Buy 3, pay 2” bundle for apples.
 *          Then you have to pay for 5 apples.
 *        - Only complete bundles qualify; leftover items are paid at full price.
 *
 * 6) Cart with discounts
 *    - You can place discounts into a cart.
 *    - Discounts apply to the entire cart.
 *
 * 7) Total calculation
 *    - First sum the price of all items.
 *    - Apply discounts in this order: Bundle → Fixed → Percentage.
 *    - Keep all selected offers in the cart. For each item, apply only the bundle
 *      that yields the most free items at its current quantity. Reevaluate when quantities change.
 *
 * 8) Operators on Cart
 *    - Provide these operators:
 *      - `Cart.plus(Pair<ItemId, UInt>): Cart`
 *      - `Cart.plus(ItemId): Cart`
 *      - `Cart.plus(Discount): Cart`
 *      - `Cart.plus(List<Discount>): Cart`
 *
 * 9) Structure
 *    - Split your implementation across multiple files.
 *    - Use only data classes, value classes and sealed interfaces.
 *
 * 10) Create an example scenario
 *    - Shop prices: banana €0.90, apple €0.60, golden fig €16.00.
 *    - Cart contents: 3 bananas, 7 apples, 2 golden figs.
 *    - Discounts in cart:
 *        - 20% off
 *        - Buy 3 apples for the price of 2
 *        - €1.50 off
 *    - Print the total.
 *    - Expected output: €28.96
 *
 * ## Resources
 * - [Value classes](https://kotlinlang.org/docs/inline-classes.html)
 */
fun main() {

}
