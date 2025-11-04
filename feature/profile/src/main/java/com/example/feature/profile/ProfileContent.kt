package com.example.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.model.Pokemon
import com.example.core.common.ui.R
@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    pokemon: Pokemon
){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .components {
                // Add the modern ImageDecoderDecoder for SDK 28+
                if (android.os.Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()

        AsyncImage(
            model = pokemon.animatedUrl,
            contentDescription = pokemon.name,
            imageLoader = imageLoader,
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
        )

        Text(
           text =  pokemon.name
        )

        Text(
            text = stringResource(R.string.pokdex_index) + pokemon.pokedexIndex.toString()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileContent(){
    ProfileContent(
        pokemon = Pokemon(
            0,
            nameField = "Pikachu",
            url = "https://pokeapi.co/api/v2/pokemon/25"
        )
    )
}