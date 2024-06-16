package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeCard(
    modifier: Modifier = Modifier
) {
    var state by remember { mutableStateOf(0) }
    var numClicks by remember { mutableStateOf(1) }

    val image = when (state) {
        0 -> painterResource(id = R.drawable.lemon_tree)
        1 -> painterResource(id = R.drawable.lemon_squeeze)
        2 -> painterResource(id = R.drawable.lemon_drink)
        else -> painterResource(id = R.drawable.lemon_restart)
    }

    val imageDescription = when (state) {
        0 -> stringResource(id = R.string.lemonTree_description)
        1 -> stringResource(id = R.string.lemon_description)
        2 -> stringResource(id = R.string.glassOfLemonade_description)
        else -> stringResource(id = R.string.emptyGlass_description)
    }

    val message = when (state) {
        0 -> stringResource(id = R.string.tree_string)
        1 -> stringResource(id = R.string.lemon_string)
        2 -> stringResource(id = R.string.lemonade_string)
        else -> stringResource(id = R.string.glass_string)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TextButton(
            modifier = Modifier
                .background(
                    Color(195, 236, 210),
                    shape = RoundedCornerShape(15)
                )
                .height(200.dp)
                .width(200.dp),
            onClick = {
                numClicks--
                if (numClicks == 0) {
                    if (state == 3) state = 0 else state++
                    numClicks = if (state == 1) (2..4).random() else 1
                }
            }
        ) {
            Image(
                painter = image,
                contentDescription = imageDescription
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = message,
            fontSize = 16.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LemonadeApp() {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Row (
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color(249, 228, 76))
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
        ){
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
        LemonadeCard(modifier = Modifier.fillMaxSize())
    }
}