package com.example.ruta2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ruta2.ui.theme.Ruta2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ruta2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WeatherScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        WeatherForCity("Ankara", 27, 31, 82)
        WeatherForCity("Tokyo", 32, 36, 10)
        WeatherForCity("Cape Town", 59, 64, 2)
        WeatherForCity("Guatemala City", 50, 55, 7)
    }
}

@Composable
fun WeatherForCity(cityName: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(text = "City: $cityName")
        Text(text = "Low temperature: $lowTemp, High temperature: $highTemp")
        Text(text = "Chance of rain: $chanceOfRain%")
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    Ruta2Theme {
        WeatherScreen()
    }
}