package com.example.artspaceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    val firstImage = R.drawable.m2_f87
    val secondImage = R.drawable.m3_f80
    val thirdImage = R.drawable.m4_g82
    val fourthImage = R.drawable.m5_cs
    var title by remember { mutableIntStateOf(R.string.bmw1) }
    var year by remember { mutableIntStateOf(R.string.bmw_year) }
    var currentArtWork by remember { mutableIntStateOf(firstImage) }
//    var imageResource by remember { mutableStateOf(currentArtWork) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        ArtDisplay(currentArtWork = currentArtWork, contentDescription = title)
        Spacer(modifier = modifier.size(20.dp))
        ArtTitle(title = title, year = year)
        Spacer(modifier = modifier.size(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    when (currentArtWork) {
                        firstImage -> {
                            currentArtWork = fourthImage
                            title = R.string.bmw4
                            year = R.string.bmw_year4
                        }

                        secondImage -> {
                            currentArtWork = firstImage
                            title = R.string.bmw1
                            year = R.string.bmw_year
                        }

                        thirdImage -> {
                            currentArtWork = secondImage
                            title = R.string.bmw2
                            year = R.string.bmw_year2
                        }

                        else -> {
                            currentArtWork = thirdImage
                            title = R.string.bmw3
                            year = R.string.bmw_year3
                        }
                    }
                },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.black)
                )
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                onClick = {
                    when (currentArtWork) {
                        firstImage -> {
                            currentArtWork = secondImage
                            title = R.string.bmw2
                            year = R.string.bmw_year2
                        }

                        secondImage -> {
                            currentArtWork = thirdImage
                            title = R.string.bmw3
                            year = R.string.bmw_year3
                        }

                        thirdImage -> {
                            currentArtWork = fourthImage
                            title = R.string.bmw4
                            year = R.string.bmw_year4
                        }

                        else -> {
                            currentArtWork = firstImage
                            title = R.string.bmw1
                            year = R.string.bmw_year
                        }
                    }
                },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.gray_900)
                )
            }
        }
    }
}


@Composable
fun ArtDisplay(
    @DrawableRes currentArtWork: Int,
    @StringRes contentDescription: Int
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(40.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(17.dp)
//                .background(Color(0xFF8B8C8C))

        ) {
            Image(
                painter = painterResource(currentArtWork),
                contentDescription = stringResource(id = contentDescription),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
fun ArtTitle(
    @StringRes title: Int,
    @StringRes year: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .height(200.dp),  // Fixed height for the ArtTitle container
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(
                start = 14.dp,
                top = 16.dp,
                end = 24.dp,
            ),
            text = stringResource(id = title),  // Artwork title
            color = colorResource(id = R.color.gray_900),
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 20.sp,
            textAlign = TextAlign.Left,  // Aligns the text to the center horizontally
            maxLines = Int.MAX_VALUE,  // Allows the text to span multiple lines
            lineHeight = 28.sp  // Optional: Adjust the line height to improve readability
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(
                bottom = 5.dp
            ),
            text = ":${stringResource(id = year)}",  // Artist name and year
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 24.sp,
            textAlign = TextAlign.Left
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}