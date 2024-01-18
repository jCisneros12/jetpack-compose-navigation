package com.jcisneros12.composenavigation.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jcisneros12.composenavigation.data.Fruit
import com.jcisneros12.composenavigation.data.findFruit
import com.jcisneros12.composenavigation.data.fruitList

@Composable
fun FruitDetailScreen(navController: NavController, fruit: Fruit?) {

    if (fruit != null) {
        Text(text = fruit.name)
    }
    else {
        navController.popBackStack()
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFruitDetailScreen() {
    FruitDetailScreen(navController = rememberNavController(), fruitList[1])
}