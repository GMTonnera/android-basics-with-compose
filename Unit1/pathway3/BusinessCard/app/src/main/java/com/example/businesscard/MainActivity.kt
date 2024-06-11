package com.example.businesscard

import android.graphics.BlendModeColorFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCard(
                    "Gustavo Mello Tonnera",
                    "Koltin Developer",
                    "gmtonnera@gmail.com",
                    "(61) 99955-3726",
                    "https://github.com/GMTonnera",
                    "https://www.instagram.com/gugs_tonnera"
                )
            }
        }
    }
}

@Composable
fun Header(name: String, title: String, image: Painter, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = title,
            fontSize = 19.sp,
            fontWeight = FontWeight.W300,
            color = Color.White,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Image(
            painter = image,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(300.dp)
        )
    }
}

@Composable
fun ContactCard(
    email: String,
    phoneNumber: String,
    gitHub: String,
    instagram: String,
    modifier: Modifier = Modifier
) {
    val contactModifier: Modifier = Modifier
        .padding(end = 10.dp)

    val rowModifier: Modifier = Modifier
        .padding(3.dp)

    Column(

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = rowModifier
        ) {
            Icon(
                Icons.Rounded.Call,
                contentDescription = null,
                modifier = contactModifier,
                tint = Color.DarkGray
            )
            Text(
                text = phoneNumber,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.W300
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = rowModifier
        ) {
            Icon(
                Icons.Rounded.MailOutline,
                contentDescription = null,
                modifier = contactModifier,
                tint = Color.White
            )
            Text(
                text = email,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.W300
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = rowModifier
        ) {
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                modifier = contactModifier,
                tint = Color.Yellow
            )
            Text(
                text = gitHub,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.W300
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = rowModifier
        ) {
            Icon(
                Icons.Rounded.Person,
                contentDescription = null,
                modifier = contactModifier,
                tint = Color.Red
            )
            Text(
                text = instagram,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.W300
            )
        }
    }

}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    email: String,
    phoneNumber: String,
    gitHub: String,
    instagram: String,
    modifier: Modifier = Modifier
) {
    val image: Painter = painterResource(id = R.drawable.foto_slack)
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Header(
            name = name,
            title = title,
            image = image
        )
        ContactCard(
            email = email,
            phoneNumber = phoneNumber,
            gitHub = gitHub,
            instagram = instagram
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(
            "Gustavo Mello Tonnera",
            "Kotlin Developer",
            "gmtonnera@gmail.com",
            "(61) 99955-3726",
            "https://github.com/GMTonnera",
            "https://www.instagram.com/gugs_tonnera"
        )
    }
}