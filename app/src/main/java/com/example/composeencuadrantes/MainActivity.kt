package com.example.composeencuadrantes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeencuadrantes.ui.theme.ComposeEnCuadrantesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeEnCuadrantesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FourComposedCards()
                }
            }
        }
    }
}

@Composable
fun ComposeCard(title: String, content: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            modifier = modifier,
        )
    }
}

@Composable
fun FourComposedCards(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            ComposeCard(
                title = stringResource(id = R.string.text_composable_tittle_text),
                content = stringResource(id = R.string.text_composable_description),
                color = Color.Green,
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                title = stringResource(id = R.string.image_composable_title),
                content = stringResource(id = R.string.image_composable_description),
                color = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ComposeCard(
                title = stringResource(id = R.string.row_composable_title),
                content = stringResource(id = R.string.row_composable_description),
                color = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                title = stringResource(id = R.string.column_composable_title),
                content = stringResource(id = R.string.column_composable_description),
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun TwoComposedCardsPreview() {
    ComposeEnCuadrantesTheme {
        FourComposedCards()
    }
}