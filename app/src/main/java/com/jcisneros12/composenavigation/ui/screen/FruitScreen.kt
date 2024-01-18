package com.jcisneros12.composenavigation.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jcisneros12.composenavigation.Screen
import com.jcisneros12.composenavigation.data.Fruit
import com.jcisneros12.composenavigation.data.fruitList

@Composable
fun FruitScreen(navController: NavController, fruitList: List<Fruit>) {
    LazyColumn {
        items(fruitList) { fruit ->
            FruitItem(fruit = fruit) {
                navController.navigate(Screen.FruitDetailScreen.route + "/${fruit.id}")
            }
        }
    }
}

@Composable
fun FruitItem(
    fruit: Fruit,
    onClick: (fruit: Fruit) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    onClick(fruit)
                },
            text = fruit.name
        )
    }
    Divider()
}

@Preview(showBackground = true)
@Composable
private fun FruitItemPreview() {
    FruitItem(
        fruit = fruitList.first(),
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun FruitScreenPreview() {
    FruitScreen(navController = rememberNavController(), fruitList)
}