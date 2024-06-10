package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                QuadrantsComponent()
            }
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ){
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify
            )
        }

    }
}

@Composable
fun QuadrantsComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant1_title),
                description = stringResource(R.string.quadrant1_description),
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.5f)
                    .background(Color(0xFFEADDFF))
            )
            Quadrant(
                title = stringResource(R.string.quadrant2_title),
                description = stringResource(R.string.quadrant2_description),
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .background(Color(0xFFD0BCFF))
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant3_title),
                description = stringResource(R.string.quadrant3_description),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .background(Color(0xFFB69DF8))
            )
            Quadrant(
                title = stringResource(R.string.quadrant4_title),
                description = stringResource(R.string.quadrant4_description),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantsComponent()
    }
}