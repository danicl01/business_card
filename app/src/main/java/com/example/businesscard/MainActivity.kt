package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(android.graphics.Color.parseColor("#bae3c5"))
                ) {
                    PresentationSection("Daniel Cruz", "Android student")
                    ContactInfoText("+34 928 435 435", "@AndroidDev", "androidDeveloper@gmail.com")
                }
            }
        }
    }
}

@Composable
fun PresentationSection(name: String, title : String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = modifier
                .size(height = 150.dp, width = 150.dp)
                .background(Color.Gray)
        )
        Text(
            text = name,
            fontSize = 35.sp,
            modifier = modifier
        )
        Text(
            text = title,
            fontSize = 20.sp,
            modifier = modifier
        )
    }
}

@Composable
fun ContactInfoText(
    phone : String,
    socialMedia : String,
    gmail : String,
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.padding(start = 80.dp, bottom = 50.dp)
    ){
        Row {
            Icon(
                painter = painterResource(R.drawable.baseline_phone_24),
                contentDescription = null
            )

            Text(
                text = phone
            )
        }

        Row {
            Icon(
                painter = painterResource(R.drawable.baseline_camera_alt_24),
                contentDescription = null
            )

            Text(
                text = socialMedia
            )
        }

        Row {
            Icon(
                painter = painterResource(R.drawable.baseline_email_24),
                contentDescription = null
            )

            Text(
                text = gmail
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        PresentationSection("Daniel Cruz", "Android student")
    }
    BusinessCardTheme {
        ContactInfoText("+34 928 435 435", "@AndroidDev", "androidDeveloper@gmail.com")
    }
}