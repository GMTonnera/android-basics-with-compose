package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtImage(
    @DrawableRes image: Int,
    imageDescription: String,
    modifier: Modifier = Modifier
) {
    Surface (
        color = Color(0, 0, 0),
        modifier = modifier
            .border(width = 1.dp, color = Color(255, 215, 0))
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = imageDescription,
            modifier = Modifier
                .padding(2.dp)
                .background(color = Color(0, 0, 0))

        )
    }
}

@Composable
fun ArtDescription(
    @StringRes artist: Int,
    @StringRes publishYear: Int,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier

    ) {
        Text(
            text = stringResource(id = artist),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            color = textColor,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(start = 5.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(id = publishYear),
            fontSize = 13.sp,
            fontWeight = FontWeight.Light,
            color = textColor,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(start = 5.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ArtCard(
    cardColor: Color,
    textColor: Color,
    @DrawableRes image: Int,
    @StringRes imageDescription: Int,
    @StringRes artTitle: Int,
    @StringRes artist: Int,
    @StringRes publishYear: Int,
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = cardColor)
            .size(280.dp, 420.dp)
            .border(3.dp, color = Color(255, 215, 0))
    ) {
        Text(
            text = stringResource(id = artTitle),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = textColor,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 3.dp)
                .background(
                    color = cardColor,
                    shape = RoundedCornerShape(40.dp)
                )
                .fillMaxWidth(0.95f)
        )
        ArtImage(
            image = image,
            imageDescription = stringResource(imageDescription),
            modifier = Modifier
                .size(width = 250.dp, height = 300.dp)
        )
        ArtDescription(
            artist = artist,
            publishYear = publishYear,
            textColor = textColor,
            modifier = Modifier
                .padding(10.dp)
                .size(width = 250.dp, height = 100.dp)
                .background(color = cardColor)
        )
    }
}

@Composable
fun NextPreviousButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),

        modifier = modifier
    ) {
        Text(
            text = stringResource(text),
            fontSize = 16.sp
        )
    }
}


@Composable
fun PreviousNextButtons(
    previousOnClick: () -> Unit,
    nextOnClick: () -> Unit,
    modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        NextPreviousButton(
            text = R.string.previous_button,
            onClick = previousOnClick,
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
        )
        NextPreviousButton(
            text = R.string.next_button,
            onClick = nextOnClick,
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
        )

    }
}

@Preview
@Composable
fun ArtSpaceApp() {
    var state by remember { mutableStateOf(0) }
    val image: Int = when(state) {
        0 -> R.drawable.mona_lisa
        1 -> R.drawable.vangogh_starry_night
        else -> R.drawable.creacion_de_adan
    }
    val imageDescription: Int = when(state){
        0 -> R.string.obra_de_arte_mona_lisa
        1 -> R.string.obra_de_arte_noite_estrelada
        else -> R.string.obra_de_arte_criacao_de_adao
    }
    val artTitle: Int = when(state){
        0 -> R.string.mona_lisa_title
        1 -> R.string.noite_estrelada_title
        else -> R.string.criacao_adao_title
    }
    val artist: Int = when(state){
        0 -> R.string.leonardo_da_vinci
        1 -> R.string.van_gogh
        else -> R.string.michelangelo
    }
    val publishYear: Int = when(state){
        0 -> R.string.mona_lisa_publish_year
        1 -> R.string.noite_estrelada_publish_year
        else -> R.string.criacao_adao_publish_year
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fundo_artapp),
            contentDescription = stringResource(R.string.background),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            ArtCard(
                cardColor = Color(80, 0, 0),
                textColor = Color(229, 229, 224),
                image = image,
                imageDescription = imageDescription,
                artTitle = artTitle,
                artist = artist,
                publishYear = publishYear,
                modifier = Modifier
            )
            Spacer(
                modifier = Modifier
                    .height(70.dp)
            )
            PreviousNextButtons(
                previousOnClick = {
                    state--
                    if (state < 0) state = 2
                },
                nextOnClick = {
                    state++
                    if (state > 2) state = 0
                },
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth()

            )

        }
    }
}
