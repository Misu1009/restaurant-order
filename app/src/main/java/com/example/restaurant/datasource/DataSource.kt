package com.example.restaurant.datasource

import com.example.restaurant.model.Item

object DataSource {

    val entreeMenuItems = mutableListOf<Item>(
        Item(
            name = "Cauliflower",
            description = "Whole cauliflower, brined, roasted, and deep fried",
            price = "7.00",
        ),
        Item(
            name = "Three Bean Chili",
            description = "Black beans, red beans, kidney beans, slow cooked, topped with onion",
            price = "4.00",
        ),
        Item(
            name = "Mushroom Pasta",
            description = "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic " +
                    "and olive oil",
            price = "5.50",
        )
    )

    val sideDishMenuItems = mutableListOf<Item>(
        Item(
            name = "Summer Salad",
            description = "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
            price = "2.50",
        ),
        Item(
            name = "Butternut Squash Soup",
            description = "Roasted butternut squash, roasted peppers, chili oil",
            price = "3.00",
        ),
        Item(
            name = "Spicy Potatoes",
            description = "Marble potatoes, roasted, and fried in house spice blend",
            price = "2.00",
        )
    )

    val accompanimentMenuItems = mutableListOf<Item>(
        Item(
            name = "Lunch Roll",
            description = "Fresh baked roll made in house",
            price = "0.50",
        ),
        Item(
            name = "Mixed Berries",
            description = "Strawberries, blueberries, raspberries, and huckleberries",
            price = "1.00",
        ),
        Item(
            name = "Pickled Veggies",
            description = "Pickled cucumbers and carrots, made in house",
            price = "0.50",
        )
    )
}